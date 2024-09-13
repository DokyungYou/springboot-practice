package hello.member;

import lombok.*;

@EqualsAndHashCode
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private String memberId;
    private String name;
}
