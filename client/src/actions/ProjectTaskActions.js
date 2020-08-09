import axios from "axios";
import {DELETE_PROJECT_TASKS, GET_ERRORS, GET_PROJECT_TASK, GET_PROJECT_TASKS} from "./types";

export const addProjectTask = (project_task,history) => async dispatch =>{

    try{
        await axios.post("/api/board",project_task);
        history.push("/");
        dispatch({
            type:GET_ERRORS,
            payload:{}
        });
    }
    catch (error) {
        dispatch({
            type:GET_ERRORS,
            payload:error.response.data
        });
    }
};

export const getBacklog = () => async dispatch => {
    const res = await axios.get("/api/board/all");
    dispatch({
        type:GET_PROJECT_TASKS,
        payload:res.data
    })
};

export const deleteProjectTask = pt_id => async dispatch => {
    if(window.confirm('Are you sure you want to delete Project Task ' + pt_id)
    ) {
        await axios.delete("/api/board/"+pt_id);
        dispatch({
            type: DELETE_PROJECT_TASKS,
            payload:pt_id
        });
    }
};

export const getProjectTask = (pt_id,history) => async dispatch => {
    try{
        const res = await axios.get("/api/board/"+pt_id);
        dispatch({
            type: GET_PROJECT_TASK,
            payload:res.data
        })
    }
        catch (error) {
            history.push("/")
        }
};