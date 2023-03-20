package com.codingdojo.projectmanager.controllers;

import com.codingdojo.projectmanager.model.Project;
import com.codingdojo.projectmanager.model.Task;
import com.codingdojo.projectmanager.model.User;
import com.codingdojo.projectmanager.services.ProjectService;
import com.codingdojo.projectmanager.services.TaskService;
import com.codingdojo.projectmanager.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@AllArgsConstructor
@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;
    private UserService userService;
    private TaskService taskService;
    @GetMapping("")
    public  String listBooks(Model model, HttpSession session){

        User user=(User) session.getAttribute("user");

        if(user==null)return "redirect:/";

        model.addAttribute("user", userService.findById(user.getId()));
       model.addAttribute("unassignedProjects", projectService.getUnassignedUsers(user));

       model.addAttribute("assignedProjects", projectService.getAssignedUsers(user));
        return "project.jsp";

    }

    @RequestMapping("/join/{id}")
    public String joinTeam(@PathVariable("id") Long id, HttpSession session){

        User user=(User) session.getAttribute("user");
        if(user==null){return "redirect:/";}

        User userA=userService.findById(user.getId());
        userA.getProjectMembers().add(projectService.findById(id));
        userService.updateUser(userA);


        return "redirect:/projects";
    }

    @RequestMapping("/leave/{id}")
    public String leaveTeam(@PathVariable("id") Long id, HttpSession session, Model model) {

        User user=(User) session.getAttribute("user");
        if(user==null){return "redirect:/";}

        Project project = projectService.findById(id);
        User userA = userService.findById(user.getId());

        userA.getProjectMembers().remove(project);
        userService.updateUser(userA);

        return "redirect:/projects";
    }

    @GetMapping("/new")
    public String newProject(@ModelAttribute("project") Project project, HttpSession session) {
        User user=(User) session.getAttribute("user");
        if(user==null){return "redirect:/";
        }
        return "newProject.jsp";
    }

    @PostMapping("/new")
    public String addNewProject(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {

        User user=(User) session.getAttribute("user");
        if(user==null){return "redirect:/";
        }
        if(result.hasErrors()) {
            return "newProject.jsp";
        }else {
            User userA=userService.findById(user.getId());
            project.setManager(userA);
            projectService.addProject(project);
            userA.getProjectMembers().add(project);
            userService.updateUser(userA);
            return "redirect:/projects";
        }
    }

    @GetMapping("/{id}")
    public String viewProject(@PathVariable("id")Long id,HttpSession session, Model model){
        User user=(User) session.getAttribute("user");
        if(user==null){return "redirect:/";
        }

        model.addAttribute("user",user);
        model.addAttribute("project",projectService.findById(id));

        return "viewProject.jsp";

    }

    @RequestMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") Long id, HttpSession session) {

        User user=(User) session.getAttribute("user");
        if(user==null){return "redirect:/";
        }

        Project project = projectService.findById(id);
        User userA=userService.findById(user.getId());


       /* for(Task t:taskService.projectTasks(id)) {
            taskService.deleteTask(t);
        }*/
        taskService.projectTasks(id).forEach(taskService::deleteTask);
        userA.getProjectMembers().remove(project);
        userService.updateUser(userA);
        projectService.deleteProject(project);

        return "redirect:/projects";

        //<form class="d-inline me-2" action="/projects/delete/${project.id}" method="post">
        //									<input type="hidden" name="_method" value="delete" />
        //									<button type="submit" class="btn btn-danger nav-link d-inline me-2 fw-bold text-white">delete</button>
        //								</form>
    }

    @GetMapping("/edit/{id}")
    public String openEditProject(@PathVariable("id") Long id, HttpSession session, Model model) {

        User user=(User) session.getAttribute("user");
        if(user==null){return "redirect:/";
        }

        model.addAttribute("project", projectService.findById(id));
        return "edit_project.jsp";
    }

    @PutMapping("/edit/{id}")
    public String editProject(@Valid @ModelAttribute("project") Project project,
            BindingResult result,
            HttpSession session) {

        User user=(User) session.getAttribute("user");
        if(user==null){return "redirect:/";
        }
        //User userA = userService.findById(user.getId());

        if(result.hasErrors()) {
            return "edit_project.jsp";
        }else {
           // Project thisProject = projectService.findById(id);
          //  project.setUsers(thisProject.getUsers());
          //  project.setManager(userA);

           // Project thisProject = projectService.findById(id);
           // project.setUsers(thisProject.getUsers());
            project.setManager(user);
            projectService.updateProject(project);

            projectService.updateProject(project);
            return "redirect:/projects";
        }
    }

    @GetMapping("/{id}/tasks")
    public String tasks(@PathVariable("id") Long id,@ModelAttribute("task") Task task, HttpSession session,Model model){

        User user=(User) session.getAttribute("user");
        if(user==null){return "redirect:/";
        }
        model.addAttribute("user",user);
        model.addAttribute("tasks",taskService.projectTasks(id));
        model.addAttribute("project",projectService.findById(id));

        return "task.jsp";

    }

    @PostMapping("/task/new")
    public  String newTask(@Valid @ModelAttribute("task") Task task, BindingResult result, HttpSession session){
        User user=(User) session.getAttribute("user");
        if(user==null){return "redirect:/";
        }
        if(result.hasErrors()) {
            return "task.jsp";
        }
        System.out.println(task.getTaskName());
        System.out.println(task.getProjectTasks().getProjectName());
        task.setMember(user);
        taskService.addTask(task);
        return "redirect:/projects/"+task.getProjectTasks().getId()+"/tasks";
    }




}
