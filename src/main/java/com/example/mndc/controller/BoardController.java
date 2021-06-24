package com.example.mndc.controller;

import com.example.mndc.model.vo.MilitaryUnitVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {


    @GetMapping("/lists")
    public String getBoard(){
        // TODO : 부대 정보를 보여줄 페이지입니다.
        // 육군, 해군, 공군이냐에 select문에 따라 받아올 정보가 다릅니다.
        //


        return "/board/lists";
    }

    @PostMapping("/lists")
    @ResponseBody
    public MilitaryUnitVO searchBoard(){
        // TODO : 여기서 ajax를 통해 통신받은 검색값을 보내주어, 해당 검색어에 일치하는 정보를 넘겨줍니다.
        // 검색어를 통한 select문

        return new MilitaryUnitVO();
    }

    @GetMapping("/list")
    public String getList(){
        // TODO : 여기서 해당 게시판을 보여줍니다.
        // 쿼리를 통해 들어온 값이 무어냐에 따라 해당 게시판을 보여줍니다.

        return "/board/list";
    }

    @GetMapping("/view")
    public String getView(){
        // TODO : 해당 게시판의 해당 글을 가져옵니다
        // 쿼리를 통해 들어온 값이 무어냐에 따라 해당 게시판 + 게시물을 보여줍니다.

        return "/board/view";
    }




}
