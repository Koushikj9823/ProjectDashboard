    package com.agileintelligence.projectdashboard.service;

    import com.agileintelligence.projectdashboard.domain.ProjectTask;
    import com.agileintelligence.projectdashboard.repository.ProjectTaskRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    @Service
    public class ProjectTaskService {

        @Autowired
        private ProjectTaskRepository projectTaskRepository;

        public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask){

            //In case if status is not set,automatically push it to TO_DO
            if(projectTask.getStatus()==null||projectTask.getStatus().equals("")){
                projectTask.setStatus("TO_DO");
            }
            return projectTaskRepository.save(projectTask);
        }

        public Iterable<ProjectTask> findAll(){
            return projectTaskRepository.findAll();
        }

        public ProjectTask findById(Long id){
            return projectTaskRepository.getById(id);
        }

        public void delete(Long id){
            ProjectTask projectTask = findById(id);
            projectTaskRepository.delete(projectTask);
        }
    }
