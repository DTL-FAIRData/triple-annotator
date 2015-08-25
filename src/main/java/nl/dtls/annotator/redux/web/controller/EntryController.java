package nl.dtls.annotator.redux.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.dtls.annotator.redux.model.AnnotationMetadata;

@Controller
@RequestMapping("/entry")
public class EntryController {
    @RequestMapping(method = RequestMethod.POST)
    public void annotationEntryPoint(@RequestBody AnnotationMetadata metadata, HttpServletRequest request,
            HttpServletResponse response, HttpSession session) throws IOException {
        session.setAttribute(SessionController.SESSION_METADATA_ATTR, metadata);
        response.sendRedirect(request.getContextPath() + "#/annotate/edit");
    }
}
