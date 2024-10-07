import './style.css'

export function ChatHeader({showChat, setShowChat, title}) {
    return ( 
        <header className='chat-header container'>
            <h1>{title}</h1>
            <button onClick={() => setShowChat(!showChat)}>
                {showChat ? 'fechar' : 'abrir'}
            </button>
        </header>
    )
}