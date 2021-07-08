package com.example.mndc.dyn.controller;

import com.example.mndc.dyn.service.BoardService;
import com.example.mndc.sta.model.dto.BoardDTO;
import com.example.mndc.sta.model.dto.MilitaryUnitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/lists")
    public String viewBoard(@RequestParam(defaultValue = "1") int type,
                           Model model){
        // 부대 정보를 보여줄 컨트롤러 입니다.
        model.addAttribute("list",boardService.getUnitInfo(type));

        return "/board/lists";
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
        return "/board/list";
    }
    // 게시글 보기
    @GetMapping("/view")
    public String viewBoard(@RequestParam int b_pk, // 게시물 번호
                          @RequestParam int mu_pk, // 게시판 번호
                          @RequestParam(defaultValue = "1") int page, // 페이지 번호
                          Model model){
        model.addAttribute("list",boardService.getBoardsInfo(mu_pk,page));
        model.addAttribute("board",boardService.getBoardInfo(b_pk));
        return "/board/view";
    }
    // 글쓰기
    @GetMapping("/write")
    public String writeBoard(){
        // TODO : 필터를 통해 로그인이 안 됐을시 접근 제어

        return "/board/write";
    }
    @PostMapping("/write")
    public String doWrite(BoardDTO boardDTO){
        boardService.writeBoard(boardDTO);
        return "redirect:/view";
    }
    // 수정하기
    @GetMapping("/modify")
    public String modifyBoard(@RequestParam int b_pk,
                              Model model){
        // TODO : 필터를 통해 로그인이 안 됐을시 접근 제어. 작성자인지 확인하기
        model.addAttribute("board",boardService.getBoardInfo(b_pk));
        return "/board/modify";
    }
    @PostMapping("/modify")
    public String doModify(BoardDTO boardDTO){
        boardService.modifyBoard(boardDTO);
        return "redirect:/view";
    }

    @PostMapping("/delete")
    public String doDelete(BoardDTO boardDTO){
        // TODO : 필터를 통해 로그인이 안 됐을시 접근 제어. 작성자인지 확인하기
        boardService.deleteBoard(boardDTO);
        return "redirect:/list";
    }
    
    // TODO : 추천버튼
    // TODO :
}
