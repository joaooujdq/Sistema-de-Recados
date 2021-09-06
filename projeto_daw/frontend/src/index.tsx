import * as ReactDom from 'react-dom'
import './index.css'
import './components/basics/Header'
import Header from './components/basics/Header'
import Body from './components/basics/Body'    
import Menu from './components/basics/Menu'
import Footer from 'components/basics/footer'
import 'bootstrap/dist/css/bootstrap'
import 'assets/css/styles'

const tag= <h1>Sistemas de Recados</h1>

ReactDom.render(
  <>

    {tag}
  <Header/>
  <Body msg="Voce possui um recado pendente"/>

  <Menu>
    <ul>
      <li>Funcionario</li>
      <li>Empresa</li>
      <li>Recado</li>
    </ul>
  </Menu>

  <Footer/>

  </>,
  document.getElementById('root')
)