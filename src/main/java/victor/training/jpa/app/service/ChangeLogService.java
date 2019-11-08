package victor.training.jpa.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import victor.training.jpa.app.entity.ChangeLog;
import victor.training.jpa.app.entity.ChangeLogRepo;

@RequiredArgsConstructor
@Service
public class ChangeLogService {
    private final ChangeLogRepo repo;

    public void addLog(String message) {
        repo.save(new ChangeLog(message));
    }

}
