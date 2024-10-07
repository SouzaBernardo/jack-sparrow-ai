import { ChatHeader } from './header/chat.header.component'
import { ChatMessages } from './messages/chat.messages.component'
import { ChatFooter } from './footer/chat.footer.component'
import { ChatContainer } from './container/chat.container.component'
import { TITLE, START_MESSAGE, EMPTY_MESSAGE } from '../../util/constants'

export function Chat() {    
    const ai = useAI()
    const [userId, setUserId] = useState("")
    const [showChat, setShowChat] = useState(true)
    const [messages, setMessages] = useState([START_MESSAGE])
    const [newMessage, setNewMessage] = useState(EMPTY_MESSAGE)

    useEffect(() => {
        async function fetchUserId() {
        const {token} = await ai.getUserId()
        setUserId(token)
        }
        fetchUserId()
    }, [])
    
    useEffect(() => {
        async function handleKeyDown({key}) {
        if (key === 'Enter') await handleMessage()
        }
        window.addEventListener('keydown', handleKeyDown)
        return () => {
        window.removeEventListener('keydown', handleKeyDown)
        }
    }, [newMessage])

    async function handleMessage() {
        if(!newMessage) return

        const history = await ai.sendMessage({userId, message: newMessage})
        setMessages([...history]) 
        setNewMessage(EMPTY_MESSAGE)
    }

    function handleInput({target}) {
        const {value, name} = target
        setNewMessage(old => ({...old, [name]: value}))
    }

    if (showChat) {
        return (
            <ChatContainer>
                <ChatHeader 
                    title={TITLE}
                    showChat={showChat}
                    setShowChat={setShowChat} />
                <ChatMessages messages={messages} />
                <ChatFooter
                    message={newMessage.message} 
                    handleInput={handleInput}
                    handleMessage={handleMessage} />
            </ChatContainer> 
        )
    }

    return (
        <ChatContainer>
            <ChatHeader 
                title={TITLE}
                showChat={showChat}
                setShowChat={setShowChat} />
        </ChatContainer> 
    )
}