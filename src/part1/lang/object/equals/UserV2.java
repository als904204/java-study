package part1.lang.object.equals;

import java.util.Objects;

public class UserV2 {

    private String id;

    public UserV2(String id) {
        this.id = id;
    }

    // 주소 값이 아닌, 특정 값(id)이 같다면 동등하다고 재정의 함
//    @Override
//    public boolean equals(Object obj) {
//        UserV2 user = (UserV2) obj;
//        return id.equals(user.id);
//    }


    // IDE 가 만들어주는 equals 를 사용해야 함
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserV2 userV2 = (UserV2) o;
        return Objects.equals(id, userV2.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
