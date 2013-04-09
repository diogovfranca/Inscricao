package inscricao.faces.mngbeans;

import inscricao.faces.convert.CEPConverter;
import inscricao.faces.convert.CPFConverter;
import inscricao.faces.validator.CPFValidator;
import inscricao.persistence.entity.Cursos;
import inscricao.persistence.entity.Usuarios;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.CursoJpaController;
import utfpr.persistence.controller.JpaController;

/**
 *
 * @author Wilson
 */
@ManagedBean
@RequestScoped
public class InscricaoBean extends PageBean {
    private int user = 1;
    private Usuarios usuario = new Usuarios(user);
    private int var = 2;
    private Cursos curso = new Cursos(var);
    private CPFConverter cpfConverter = new CPFConverter();
    private CEPConverter cepConverter = new CEPConverter();
    private CPFValidator cpfValidator = new CPFValidator();
    private SimpleDateFormat formatDataVencto = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat formatCompetencia = new SimpleDateFormat("MM/yyyy");

    public Usuarios getUsuarios() {
        return usuario;
    }

    public void setUsuarios(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    public Cursos getCursos() {
        return curso;
    }

    public void setCursos(Cursos curso) {
        this.curso = curso;
    }

    public CEPConverter getCepConverter() {
        return cepConverter;
    }

    public CPFConverter getCpfConverter() {
        return cpfConverter;
    }

    public CPFValidator getCpfValidator() {
        return cpfValidator;
    }
 
    private boolean validaCandidato() {
        JpaController ctl = new JpaController();
        EntityManager em = ctl.getEntityManager();
        try {
            Usuarios c = em.find(Usuarios.class, usuario.getCpf());
            return c == null;
        } finally {
            em.close();
        }
    }
    
    public List<SelectItem> getIdiomaItemList() {
        CursoJpaController ctl = new CursoJpaController();
        EntityManager em = ctl.getEntityManager();
        
        try {
            List<SelectItem> itens = new ArrayList<SelectItem>();
            List<Cursos> cursos = ctl.findAll();
            for (Cursos id: cursos) {
                itens.add(new SelectItem(id.getCurso(), id.getDescricao()));
            }
            return itens;
        } finally {
            em.close();
        }
    }
    
    public String getDataVencimento() {
        GregorianCalendar hoje = new GregorianCalendar();
        hoje.add(Calendar.DAY_OF_MONTH, 1);
        return formatDataVencto.format(hoje.getTime());
    }
    
    public String getCompetencia() {
        GregorianCalendar hoje = new GregorianCalendar();
        hoje.add(Calendar.DAY_OF_MONTH, 1);
        return formatCompetencia.format(hoje.getTime());
    }
    
    public void inscricaoAction() {
        JpaController ctl = new JpaController();
        EntityManager em = ctl.getEntityManager();
        try {
            if (validaCandidato()) {
                em.getTransaction().begin();
                em.persist(usuario);
                em.getTransaction().commit();
                info("Inscrição realizada com sucesso");
            } else {
                error("Este CPF já está inscrito");
            }            
        } catch (Exception e) {
            log("Incrição teste classificatorio", e);
            error("Não foi possível completar a operação: " + e.getLocalizedMessage());
        } finally {
            em.close();
        }
    }
}
