package com.example.mndc.controller;

import com.example.mndc.model.dto.MilitaryUnitDTO;
import com.example.mndc.service.BoardService;
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
    public String getBoard(@RequestParam(defaultValue = "1") int type,
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

    @GetMapping("/list")
    public String getList(@RequestParam int mu_pk,
                          Model model){
        // 여기서 해당 게시판을 보여줍니다.
        // DTO를 통해 Board 정보 + m_nm(닉네임)정보까지 들고옵니다.
        model.addAttribute("list",boardService.getBoardInfo(mu_pk));

        return "/board/list";
    }

    @GetMapping("/view")
    public String getView(){
        // TODO : 해당 게시판의 해당 글을 가져옵니다
        // 쿼리를 통해 들어온 값이 무어냐에 따라 해당 게시판 + 게시물을 보여줍니다.
        // ? board정보만을 가져와 getList로 넘길까?
        // logic적으로 모듈화를 통해 따로 동작하게 하는게 좋겠다.

        return "/board/view";
    }




}
