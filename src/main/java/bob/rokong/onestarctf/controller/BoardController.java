package bob.rokong.onestarctf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import bob.rokong.onestarctf.code.PostCategory;
import bob.rokong.onestarctf.service.BoardService;
import bob.rokong.onestarctf.vo.BoardParamVO;
import bob.rokong.onestarctf.vo.ViewParamVO;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

    private static final Logger log = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public String board(BoardParamVO boardParam, Model model) {
        if (boardParam.getCategories() == null) {
            boardParam.setCategories("('"+PostCategory.NOTICE.name()+"')");
        }
        model.addAttribute("boardParam", boardParam);

        try {
            model.addAttribute("posts", boardService.getPosts(boardParam));
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            log.error("board.error", e);
        }

        return "board";
    }

    @GetMapping("/view")
    public String view(ViewParamVO viewParamVO, Model model) {
        model.addAttribute("viewParam", viewParamVO);
        model.addAttribute("post", boardService.getPost(viewParamVO));
        return "view";
    }

    @GetMapping("/adminView")
    public String adminView(ViewParamVO viewParamVO, HttpServletRequest request, Model model) {
        // Check Remote Address and User
        if (!"127.0.0.1".equals(request.getRemoteAddr()) || !"admin".equals(request.getRemoteUser())) {
            log.warn("auth.failed | remoteAddr: {} | remoteUser: {}", request.getRemoteAddr(), request.getRemoteUser());
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Local Admin Only");
        }

        // Set Admin Role
        viewParamVO.setAdmin(true);
        model.addAttribute("viewParam", viewParamVO);
        model.addAttribute("post", boardService.getPost(viewParamVO));

        return "view";
    }
}