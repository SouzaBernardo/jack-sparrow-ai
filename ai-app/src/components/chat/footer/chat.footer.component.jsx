import './style.css'

export function ChatFooter({handleMessage, handleInput, message}) {
    return (
        <footer className='user-interation container'>
            <div>
            <input 
                className='input'
                type="text" 
                name='message'
                value={message} 
                onChange={handleInput}
                placeholder='Mensagem...' 
                />
            <button 
                className='button' 
                onClick={handleMessage}>
                enviar
            </button>
            </div>
        </footer>
    )
}