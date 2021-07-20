package com.example.mndc.dyn.controller;

import com.example.mndc.dyn.service.BoardService;
import com.example.mndc.dyn.service.FavService;
import com.example.mndc.dyn.service.UserService;
import com.example.mndc.dyn.utils.Path;
import com.example.mndc.sta.auth.PrincipalDetails;
import com.example.mndc.sta.model.FavEntity;
import com.example.mndc.sta.model.MilitaryUnitEntity;
import com.example.mndc.sta.model.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController extends Path {

    @Autowired
    private BoardService boardService;
    @Autowired
    private UserService userService;
    @Autowired
    private FavService favService;

    @GetMapping("/lists")
    public String viewBoard(@RequestParam(defaultValue = "1") int type,
                           Model model){
        // 부대 정보를 보여줄 컨트롤러 입니다.
        model.addAttribute("list",boardService.getUnitInfo(type));

        return BOARD+LISTS;
    }

    @PostMapping("/lists")
    @ResponseBody
    public List<MilitaryUnitEntity> searchBoard(String search,
                                                int mu_pk){
        // TODO : 여기서 ajax를 통해 통신받은 검색값을 보내주어, 해당 검색어에 일치하는 정보를 넘겨줍니다.
        // 검색어를 통한 select문
        List<MilitaryUnitEntity> list = new ArrayList<>();
        list = boardService.getUnitInfoSearch(search,mu_pk);
        return list;
    }

    // 게시판
    @GetMapping("/list")
    public String viewList(@RequestParam int mu_pk, // 게시판 번호
                          @RequestParam(defaultValue = "1") int page, // 페이지 번호
                          Model model){
        model.addAttribute("unit",boardService.getUnitName(mu_pk));
        model.addAttribute("list",boardService.getBoardsInfo(mu_pk,page));
        return BOARD+LIST;
    }
    // 게시글 보기
    @GetMapping("/view")
    public String viewBoard(@RequestParam int b_pk, // 게시물 번호
                          @RequestParam int mu_pk, // 게시판 번호
                          @RequestParam(defaultValue = "1") int page, // 페이지 번호
                          Model model){
        model.addAttribute("unit",boardService.getUnitName(mu_pk));
        model.addAttribute("list",boardService.getBoardsInfo(mu_pk,page));
        model.addAttribute("board",boardService.getBoardInfo(b_pk));
        return BOARD+VIEW;
    }
    // 글쓰기
    @GetMapping("/write")
    public String writeBoard(@AuthenticationPrincipal PrincipalDetails principalDetails){
        if(!userService.isLogin(principalDetails)){ //
            return REDIRECT+LOGIN;
        }

        return BOARD+WRITE;
    }
    @PostMapping("/write")
    public String doWrite(BoardDTO boardDTO){
        boardService.writeBoard(boardDTO);
        return REDIRECT+VIEW;
    }
    // 수정하기
    @GetMapping("/modify")
    public String modifyBoard(@RequestParam int b_pk,
                              Model model,
                              @AuthenticationPrincipal PrincipalDetails principalDetails){
        if(!userService.isLogin(principalDetails)){ //
            return REDIRECT+LOGIN;
        }else if(!userService.isLoginMatch(principalDetails,b_pk)){
            return ""; // 잘못된 접근. goback 또는 List로!
        }
        model.addAttribute("board",boardService.getBoardInfo(b_pk));
        return BOARD+MODIFY;
    }
    @PostMapping("/modify")
    public String doModify(BoardDTO boardDTO){
        boardService.modifyBoard(boardDTO);
        return REDIRECT+VIEW;
    }

    @PostMapping("/delete")
    public String doDelete(BoardDTO boardDTO,
                           @AuthenticationPrincipal PrincipalDetails principalDetails){
        if(!userService.isLogin(principalDetails)){ //
            return REDIRECT+LOGIN;
        }else if(!userService.isLoginMatch(principalDetails,boardDTO.getB_pk())){
            return ""; // 잘못된 접근. goback 또는 List로!
        }
        boardService.deleteBoard(boardDTO);
        return REDIRECT+LIST;
    }

    @PostMapping("/fav")
    @ResponseBody
    public int configFav(@RequestParam FavEntity favEntity,
                         @RequestParam int flag,
                         @AuthenticationPrincipal PrincipalDetails principalDetails){
        // TODO : 뭘 보내줄까?
//        favEntity.setM_pk(principalDetails.getUserEntity().getM_pk());

        return favService.favProc(favEntity,flag);
    }
}
