package com.example.mndc.dyn.controller;


import com.example.mndc.dyn.service.*;
import com.example.mndc.dyn.service.api.*;
import com.example.mndc.dyn.utils.APIData;
import com.example.mndc.dyn.utils.Path;
import com.example.mndc.sta.auth.PrincipalDetails;
import com.example.mndc.sta.model.BoardEntity;
import com.example.mndc.sta.model.CmtEntity;
import com.example.mndc.sta.model.FavEntity;
import com.google.gson.JsonObject;
import org.apache.commons.io.FilenameUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.UUID;

@Controller
public class BoardController extends Path {

    @Autowired
    private BoardService boardService;
    @Autowired
    private UserService userService;
    @Autowired
    private FavService favService;
    @Autowired
    private APIMNDService apimndService;
    @Autowired
    private APIBHService apibhService;
    @Autowired
    private APIXMLService apixmlService;
    @Autowired
    private CmtService cmtService;

    @GetMapping(BOARD+DELETE)
    public String delBoard(BoardEntity boardEntity){
        boardService.delBoard(boardEntity);
        return REDIRECT+"/";
    }

    @GetMapping(CMT+DELETE)
    public String delCmt(CmtEntity cmtEntity, int bpk){
        cmtService.delCmt(cmtEntity);
        return REDIRECT+BOARD+VIEW+"?bpk="+bpk;
    }

    @GetMapping("/")
    public String gomain(Model model,
                         @RequestParam(defaultValue = "1")int page, HttpServletResponse response){
        // todo : type을 enum 또는 interface로 관리하여 값을 넣기
        model.addAttribute("maxPage",boardService.getPage());
        model.addAttribute("list",boardService.getBoardList(page));
        model.addAttribute("saleList",apimndService.searchMndSale(1,10));
        model.addAttribute("jobList",apibhService.searchBhJob("1","0","0").subList(0,10));
        return "/index";
    }

    @GetMapping(BOARD+WRITE)
    public String write(){

        return BOARD+WRITE;
    }

    @PostMapping(BOARD+WRITE)
    public String writeP(@AuthenticationPrincipal PrincipalDetails principalDetails,
                         BoardEntity boardEntity){
        Long mpk = principalDetails.getUserEntity().getMpk();
        boardEntity.setMpk(mpk);
        boardService.writeBoard(boardEntity);
        return REDIRECT+"/";
    }

    //ck에디터의 이미지만 사용되는 ㅇㅇ
    @PostMapping("/ckUpload")
    public static void postCKEditorImg(HttpServletRequest request,
                                       HttpServletResponse response,
                                       HttpSession session,
                                       @RequestParam MultipartFile upload) throws Exception{
        // 여기서 저장경로 지정. 난 내 PC기준으로 했음
        String uploadPath = "~/imsi";
        String filename = upload.getOriginalFilename();
//        System.out.println("filename : "+filename);
        String ex = "."+ FilenameUtils.getExtension(filename);
//        System.out.println("ex : "+ex);

        UUID uid = UUID.randomUUID();
//
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
//
        String ckUploadPath = new StringBuilder()
                .append(uploadPath)
                .append(uid)
                .append(ex).toString();
        String fileUrl = new StringBuilder()
                .append(uid)
                .append(ex).toString();

        File saveFile = new File(ckUploadPath);
        upload.transferTo(saveFile);


        PrintWriter printWriter = response.getWriter();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("uploaded",1);
        jsonObject.addProperty("url",ckUploadPath);

        printWriter.println(jsonObject);
        printWriter.flush();

//        System.out.println("url : "+fileUrl);
//        System.out.println("ckUploadPath : "+ckUploadPath);
    }

    @GetMapping(BOARD+VIEW)
    public String view(Model model,
                       int bpk){
        boardService.upCount(bpk);
        model.addAttribute("board",boardService.getBoard(bpk));
        model.addAttribute("cmtList",cmtService.getCmtList(bpk));
        return BOARD+VIEW;
    }

    @ResponseBody
    @GetMapping(BOARD+ADDLIKE)
    public int addLike(FavEntity favEntity){
        return favService.configFav(favEntity);
    }

    @PostMapping(BOARD+COMMNET)
    public String addCommnet(CmtEntity cmtEntity){
        System.out.println("cmtEntity : "+cmtEntity);
        cmtService.addCmt(cmtEntity);
        return REDIRECT+BOARD+VIEW+"?bpk="+cmtEntity.getBpk();
    }


    @GetMapping("/history")
    public String goHistory(){
        //
        return "/board/history";
    }

    @GetMapping("jobSearch")
    public String goJobSearch(Model model,
                              @RequestParam(defaultValue = "1") String page,
                              @RequestParam(defaultValue = "0") String location,
                              @RequestParam(defaultValue = "0") String category){

        model.addAttribute("locations", APIData.getJobSearchLocations());
        model.addAttribute("categories",APIData.getJobSearchCategories());
        model.addAttribute("list",apibhService.searchBhJob(page, location, category));
        return "/board/jobSearch";
    }
    @GetMapping("benefitZone")
    public String goBenefitZone(Model model){
        // 페이지 값 어떻게  받아서 어떻게 넘길지!
        model.addAttribute("list",apimndService.searchMndJob(1,10));
//        model.addAttribute("list",apimndService.searchMndJob(APIMNDService.MND_SALE,1,10));

        return BOARD+BENETFITZONE;
    }

    @GetMapping("/benefitZone/food")
    public String bzFood(Model model){

        model.addAttribute("title","음식존");
        model.addAttribute("list",apixmlService.searchTKGyeonjuFood());
        return BOARD+BENETFITZONEList;
    }
    @GetMapping("/benefitZone/tour")
    public String bzTour(Model model){
        model.addAttribute("title","여행존");
        model.addAttribute("list",apixmlService.searchTourism());
        return BOARD+BENETFITZONEList;
    }
    @GetMapping("/benefitZone/movie")
    public String bzMovie(Model model){
        LocalDate date = LocalDate.now();
        model.addAttribute("title","영화존");
        model.addAttribute("list",apixmlService.searchTKCinema(String.valueOf(date.getYear()), String.valueOf(date.getMonthValue()),"50","1"));
        return BOARD+BENETFITZONEList;
    }
    @GetMapping("/benefitZone/military")
    public String bzMili(Model model){
        model.addAttribute("title","군혜택존");
        model.addAttribute("list",apimndService.searchMndSale(1,10));
        return BOARD+BENETFITZONEList;
    }
}
