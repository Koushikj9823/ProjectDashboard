    package com.dashboard.projectdashboard.web;

    import com.dashboard.projectdashboard.domain.ProjectTask;
    import com.dashboard.projectdashboard.service.ProjectTaskService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.validation.BindingResult;
    import org.springframework.validation.FieldError;
    import org.springframework.web.bind.annotation.*;

    import javax.validation.Valid;
    import java.util.HashMap;
    import java.util.Map;

    @RestController
    @RequestMapping("/api/board")
    @CrossOrigin
    public class ProjectTaskController {

        @Autowired
        private ProjectTaskService service;

        @PostMapping("")
        public ResponseEntity<?> addProjectTaskToBoard(@Valid  @RequestBody ProjectTask projectTask, BindingResult result){

            if(result.hasErrors()){
                Map<String,String> errorMap = new HashMap<>();
                for(FieldError error: result.getFieldErrors()){
                    errorMap.put(error.getField(),error.getDefaultMessage());
                }
                return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);

            }
            ProjectTask newPT = service.saveOrUpdateProjectTask(projectTask);
            return new ResponseEntity<>(newPT, HttpStatus.CREATED);
        }

        @GetMapping("/all")
        public Iterable<ProjectTask> getAllPTs(){
                return service.findAll();
        }
        @GetMapping("/{id}")
        public ResponseEntity<?> getPTById(@PathVariable Long id){
            ProjectTask projectTask = service.findById(id);
            return new ResponseEntity<ProjectTask>(projectTask,HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteProjectTask(@PathVariable Long id){
            service.delete(id);
            return new ResponseEntity<String>("Project Task of Id: "+id+" Deleted",HttpStatus.OK);
        }
    }
