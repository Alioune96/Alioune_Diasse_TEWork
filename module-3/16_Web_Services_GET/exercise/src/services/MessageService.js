import axios from "axios";

const champFun = axios.create({
    baseURL: import.meta.env.VITE_REMOTE_API
});

export default{
    getisFun(id){
        return champFun.get(`/messages/${id}`)
    }
}