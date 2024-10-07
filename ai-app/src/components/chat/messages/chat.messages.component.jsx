import './style.css'

export function ChatMessages({messages = []}) {
    return (
        <div className='scroll messages-size'>
            <main className='messages container'>
            {
                messages.map((a, index) => 
                <p key={index} className={`${a.origin} message`} >
                    {a.message}
                </p>)
            }
            </main>
        </div>
    )
}