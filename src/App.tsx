import {useEffect, useState} from 'react'

type SessionProps = {
    id?: number,
    content?: string,
};

function App() {

    const [session, setSession] = useState<SessionProps>({});

    useEffect((): void => {
        fetch("http://localhost:8080/session?sessionName=first")
            .then(res => res.json())
            .then(res => setSession(res));
    }, []);

    return (
        <>
            <div>GymBro</div>
            {session.content ?? "Loading..."}
        </>
    )
}

export default App;
