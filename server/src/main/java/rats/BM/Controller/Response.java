package rats.BM.Controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    private T data;

    public Response(T data){
        this.data = data;
    }
}
