package app.api;

import java.util.concurrent.atomic.AtomicLong;

import app.model.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class SessionController {

    private static final String template = "Session %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/sessions")
    public String session() {
        return "All Sessions";
    }

    @GetMapping("/session")
    public Session session(@RequestParam(defaultValue = "last") String sessionName) {
        return new Session(counter.incrementAndGet(), template.formatted(sessionName));
    }
}