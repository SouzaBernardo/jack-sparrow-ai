
import axios from 'axios'

export function useAI() {
    const instance = axios.create({
        baseURL: "http://localhost:8080"
    })

    async function sendMessage({userId, message}) {
        const response = await instance.post("/v1/chat", {userId, message})
        return response.data
    }

    async function getUserId() {
        const response = await instance.get("/v1/chat/user")
        return response.data
    }

    return {
        sendMessage,
        getUserId
    }
}