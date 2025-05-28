package worker.Inklings.toysbackend.controller.handler;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class StandardError {
    private Integer status;
    private String message;
    private String error;
    private String code;
    private LocalDateTime timestamps;
    private String path;
}
