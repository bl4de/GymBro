package app.api;

import java.util.concurrent.atomic.AtomicLong;

import app.model.Session;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/sessions")
@RestController
public class SessionController {

    private static final String template = "Session %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public String session() {
        return "All Sessions";
    }

    @GetMapping("/{sessionName}")
    public Session session(@PathVariable @RequestParam(defaultValue = "last") String sessionName) {
        return new Session(counter.incrementAndGet(), template.formatted(sessionName));
    }
}