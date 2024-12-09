package MyProject.demo.Group;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class GroupDTO {
    @NotNull
    @Pattern(regexp = "^[А-Я]{1,3}-[0-9]{2}(-[0-9])?", message = "Название группы неккоректно")
    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
