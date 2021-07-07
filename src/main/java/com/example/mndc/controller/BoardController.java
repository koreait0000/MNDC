package com.example.mndc.controller;

import com.example.mndc.auth.PrincipalDetails;
import com.example.mndc.model.dto.BoardDTO;
import com.example.mndc.model.dto.MilitaryUnitDTO;
import com.example.mndc.service.BoardService;
import com.example.mndc.service.UserService;
import com.example.mndc.util.BoardPath;
import com.example.mndc.util.UserPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController implements BoardPath, UserPath {

    @Autowired
    BoardService boardService;
    @Autowired
    UserService userService;

    @GetMapping("/lists")
    public String viewBoard(@RequestParam(defaultValue = "1") int type,
                           Model model){
        // 부대 정보를 보여줄 컨트롤러 입니다.
        model.addAttribute("list",boardService.getUnitInfo(type));

        return BOARD+LISTS;
    }

    @PostMapping("/lists")
    @ResponseBody
    public MilitaryUnitDTO searchBoard(){
        // TODO : 여기서 ajax를 통해 통신받은 검색값을 보내주어, 해당 검색어에 일치하는 정보를 넘겨줍니다.
        // 검색어를 통한 select문

        return new MilitaryUnitDTO();
    }

    // 게시판
    @GetMapping("/list")
    public String viewList(@RequestParam int mu_pk, // 게시판 번호
                          @RequestParam(defaultValue = "1") int page, // 페이지 번호
                          Model model){
        model.addAttribute("list",boardService.getBoardsInfo(mu_pk,page));
        return BOARD+LIST;
    }
    // 게시글 보기
    @GetMapping("/view")
    public String viewBoard(@RequestParam int b_pk, // 게시물 번호
                          @RequestParam int mu_pk, // 게시판 번호
                          @RequestParam(defaultValue = "1") int page, // 페이지 번호
                          Model model){
        model.addAttribute("list",boardService.getBoardsInfo(mu_pk,page));
        model.addAttribute("board",boardService.getBoardInfo(b_pk));
        return BOARD+VIEW;
    }
    // 글쓰기
    @GetMapping("/write")
    public String writeBoard(@AuthenticationPrincipal PrincipalDetails principalDetails){
        if(userService.isLogin(principalDetails)) {
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
        if(userService.isLogin(principalDetails)) {
            return REDIRECT+LOGIN;
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
        if(userService.isLogin(principalDetails)) {
            return REDIRECT+LOGIN;
        }
        boardService.deleteBoard(boardDTO);
        return REDIRECT+LIST;
    }
    
    // TODO : 추천버튼
    // TODO :
}
