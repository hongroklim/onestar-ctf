package bob.rokong.onestarctf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bob.rokong.onestarctf.service.AuthService;
import bob.rokong.onestarctf.service.BoardService;
import bob.rokong.onestarctf.vo.LoginVO;
import bob.rokong.onestarctf.vo.UserVO;

@Controller
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    public BoardService boardService;
    @Autowired
    public AuthService authService;

    @Value("${ctf.flag1}")
    private String FLAG_1 = "**FLAG_1**";

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("notices", boardService.getRecentNotices());
        return "index";
    }

    @PostMapping("/signup")
    public String signup(LoginVO loginVO, RedirectAttributes redAttrs) {
        String targetPath = "redirect:/";

        // Authenticate
        UserVO user = authService.authenticate(loginVO);
        if (user == null) {
            log.warn("auth.invalid | id: {} | pw: {}", loginVO.getUsername(), loginVO.getPassword());
            redAttrs.addFlashAttribute("error", "auth.invalid");
            return targetPath;
        }

        // Return Flag when succeed
        redAttrs.addFlashAttribute("flag", FLAG_1);
        log.info("FLAG_1 Captured");

        return targetPath;
    }
}