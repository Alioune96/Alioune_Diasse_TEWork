import axios from "axios";


const site = axios.create({baseURL: import.meta.env.VITE_REMOTE_API})

export default{
    allList(){
        return site.get('/topics')
    },

    perTopic(id){
        return site.get(`/topics/${id}`)
    }
}