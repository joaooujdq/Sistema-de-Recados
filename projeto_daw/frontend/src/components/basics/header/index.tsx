import './index.css'

const Header = () => {
    return (
        <>
         <header className="header mt-auto py-3 ">
     <h1> Sistema de Recados</h1>
  <div className="container" id="container-header">
    <button>Meus Recados</button>
    <button>Criar Recado</button>
    <button>Funcionários Cadastrados</button>
    <button>Empresas Cadastradas</button>
  </div>
     </header>
        </>
    );
}

export default Header;