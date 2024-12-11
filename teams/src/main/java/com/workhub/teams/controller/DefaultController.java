package com.workhub.teams.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class DefaultController {

    @GetMapping
    public String defaultPage() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Teams Module</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            margin: 0;\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background: linear-gradient(to bottom, #0073e6, #f2f2f2);\n" +
                "            color: #333;\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" +
                "            height: 100vh;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .container {\n" +
                "            background-color: #fff;\n" +
                "            padding: 30px;\n" +
                "            border-radius: 10px;\n" +
                "            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\n" +
                "            max-width: 500px;\n" +
                "            width: 90%;\n" +
                "        }\n" +
                "\n" +
                "        .container h1 {\n" +
                "            font-size: 2em;\n" +
                "            color: #0073e6;\n" +
                "            margin-bottom: 10px;\n" +
                "        }\n" +
                "\n" +
                "        .container p {\n" +
                "            font-size: 1.2em;\n" +
                "            color: #555;\n" +
                "            margin-top: 0;\n" +
                "        }\n" +
                "\n" +
                "        .container .status {\n" +
                "            margin-top: 20px;\n" +
                "            padding: 10px 15px;\n" +
                "            background-color: #0073e6;\n" +
                "            color: #fff;\n" +
                "            font-size: 1.1em;\n" +
                "            font-weight: bold;\n" +
                "            border-radius: 5px;\n" +
                "        }\n" +
                "\n" +
                "        footer {\n" +
                "            position: absolute;\n" +
                "            bottom: 10px;\n" +
                "            width: 100%;\n" +
                "            text-align: center;\n" +
                "            font-size: 0.9em;\n" +
                "            color: #888;\n" +
                "        }\n" +
                "\n" +
                "        footer a {\n" +
                "            color: #0073e6;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <h1>Team Module</h1>\n" +
                "        <div class=\"status\">The Team Module is running!</div>\n" +
                "    </div>\n" +
                "\n" +
                "    <footer>\n" +
                "        Powered by <a href=\"#\">WorkHub</a>\n" +
                "    </footer>\n" +
                "</body>\n" +
                "</html>\n";
    }
}
