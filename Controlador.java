import java.util.InputMismatchException;
public class Controlador {
    boolean ciclo = true;
     public void IniciarPrograma(vista vista1){
        ListaDeUsuarios listaDeUsuarios1 = new ListaDeUsuarios();
        while(ciclo == true){
            vista1.Inicio();
            if(vista1.solicitarI(null) == 1 ){
                crear_usuario(vista1, listaDeUsuarios1);
            }
            if(vista1.solicitarI(null) == 2){

            }
            





        }
     }





    public void crear_usuario(vista vista1,ListaDeUsuarios listaDeUsuarios1){
        vista1.TipoDeUsuarioCreado();
        
        if(vista1.RespuestaI == 1){
            Voluntario voluntario1 = new Voluntario();
            vista1.CrearUsuarioVoluntario(voluntario1);
            listaDeUsuarios1.UsuariosVoluntarios.add(voluntario1);
        }
        else if(vista1.RespuestaI== 2){
            Administrador_Evento admin1 = new Administrador_Evento();
            vista1.CrearUsuarioAdmin(admin1);
            listaDeUsuarios1.UsuariosAdministrativos.add(admin1);
        }
        

    }
    public void Iniciar_Sesión(Administrador_Evento admin1, vista vista1){




    }
    public void Cerrar_Sesión(){
    }
    public void Revisar_Usuario_y_Contraseña(){
        
    }
    public void Crear_Evento(){
        
    }
    public void Buscar_Eventos(){
        
    }
    public void Asignar_evento (){
        
    }
    public void Crear_Horario(){

    }


}
