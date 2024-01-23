package thonguyenvan.interviewms.util.page;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@RequiredArgsConstructor
@Data
public class PageLevel<T> implements Serializable {

    private final Collection<T> levels;
}
