import {combineReducers} from "redux";
import errorReducers from "./errorReducers";
import projectTaskReducers from "./projectTaskReducers";

export default combineReducers({

    errors: errorReducers,
    project_tasks:projectTaskReducers
});

