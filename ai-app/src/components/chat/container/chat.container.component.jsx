export function ChatContainer({children}) {
    return (
        <div className='chat'>
            <div className='chat-scope'>
                {children}
            </div>
        </div>
    )
}