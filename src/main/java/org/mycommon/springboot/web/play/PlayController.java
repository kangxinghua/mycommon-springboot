package org.mycommon.springboot.web.play;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mycommon.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/play")
public class PlayController {
    private static Logger logger = LogManager.getLogger(PlayController.class);
    @Autowired
    private HelloService helloService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        logger.info("==================================================");
        model.addAttribute("name", helloService.getName(name));
        return "play/index";
    }
}
