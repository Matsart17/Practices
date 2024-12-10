package MyProject.demo.Group;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("api/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable long id) {
        return groupService.getGroupById(id);
    }

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @PostMapping
    public Group addGroup(@Valid @RequestBody GroupDTO groupDTO) {
        return groupService.addGroup(groupService.convertDTOtoGroup(groupDTO));
    }

    @PutMapping("/{id}")
    public Group updateGroupById(@PathVariable long id, @Valid @RequestBody GroupDTO groupDTO) {
        return groupService.updateGroupById(groupService.convertDTOtoGroup(groupDTO), id);
    }

    @DeleteMapping("/{id}")
    public void deleteGroupById(@PathVariable long id) {
        groupService.deleteGroupById(id);
    }
}
