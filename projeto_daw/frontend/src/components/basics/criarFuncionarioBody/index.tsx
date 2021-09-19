
import { useEffect, useState } from "react";
import api from "../../../services/api";
import { FiArrowLeft, FiArrowRight } from "react-icons/fi";
import '../criarFuncionarioBody/index.css'
import { Link } from "react-router-dom";



interface imensagem {

    codigo_rec: number,
    empresa_rec: string,
    status_rec: string,
    prioridade_rec: string,
    setor_rec: string,
    mensagem_rec: string,
    funcionario: ifuncionario,
    empresa: iempresa,
    _links: i_links,
    tipo_rec: string
}

interface ifuncionario {
    codigo_func: number,
    nome_func: string,
    cargo_func: string,
    login_func: string,
    senha_func: string,
    tipo_func: string,
}
interface iempresa {
    codigo_emp: number,
    nome_emp: string,
    razao_emp: string,
    cnpj_emp: string,
    endereco_emp: string,
    telefone_emp: string
}

interface i_links {
    self: iself
}

interface iself {
    href: string
}

const CriarFuncionarioBody: React.FC = () => {
    const [Msg, setMsg] = useState<ifuncionario[]>([]);
    const [inputNomeFunc, setInputNomeFunc] = useState('');
    const [inputCargoFunc, setInputCargoFunc] = useState('');
    const [inputTipoFunc, setInputTipoFunc] = useState('');
    const [inputLoginFunc, setInputLoginFunc] = useState('');



    async function postMsg() {

        const response = api.post('/v1/elx/funcionarios', {
            "nome": inputNomeFunc,
            "cargo": inputCargoFunc,
            "login": inputLoginFunc,
            "senha": "password",
            "tipo": inputTipoFunc
        }).then(response => response)
            .catch(error => {
                console.log(error.response)
            });
    }

    useEffect(() => {
        postMsg()
    }, []);



    return (
        <>
            <body id='CriarFuncionarioBody'>
                <ul id='CriarFuncionarioUl'>
                    <div id='divH1'>
                        <h1>Nome Funcionario: </h1>
                        <h1>Cargo Funcionario: </h1>
                        <h1>Tipo Funcionario: </h1>
                        <h1>Login: </h1>
                        
                    </div>
                    <div id='divInput'>
                        <input type="text" value={inputNomeFunc} onChange={e => setInputNomeFunc(e.target.value)} />
                        <input type="text" value={inputCargoFunc} onChange={e => setInputCargoFunc(e.target.value)} />
                        <input type="text" value={inputTipoFunc} onChange={e => setInputTipoFunc(e.target.value)} />
                        <input type="text" value={inputLoginFunc} onChange={e => setInputLoginFunc(e.target.value)} />
                        
                    </div>
                </ul>
                <Link id='linkButton' to='/funcionarios'>
                <button onClick={postMsg}>Cadastrar</button>
                </Link>
                
            </body>
        </>
    );
}

export default CriarFuncionarioBody;

