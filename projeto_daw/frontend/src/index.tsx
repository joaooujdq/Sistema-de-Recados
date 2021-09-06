import * as ReactDom from 'react-dom'
import './index.css'
import Header from './components/basics/header/index'
import Body from './components/basics/Body'    

import Footer from 'components/basics/footer/index'
import 'bootstrap/dist/css/bootstrap.css'
import 'assets/css/styles.css'



ReactDom.render(
  <>

    
  <Header/>
  <Body msg="Voce possui um recado pendente"/>

 

  <Footer/>

  </>,
  document.getElementById('root')
)