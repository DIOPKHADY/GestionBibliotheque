
package windows;

import dao.IInscription;
import dao.IUtilisateur;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import static javax.swing.text.html.HTML.Tag.EM;
import models.Inscription;
import static models.Inscription_.statut;
import models.Utilisateurs;
import services.InscriptionService;
import services.UtilisateurServices;

/**
 *
 * @author HP
 */
public class AddUtilisateur extends javax.swing.JFrame {
      private static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("NomDeVotrePersistenceUnit");
    private static EntityManager EM = EMF.createEntityManager();
    IUtilisateur iuser=new UtilisateurServices();
    IInscription iInscription = new InscriptionService();
    Utilisateurs u;
    
    /**
     * Creates new form AddUtilisateur
     */
    public AddUtilisateur() {
        initComponents();
        
    }
private void clearField(){
    nom_txt.setText("");
    prenom_txt.setText("");
  nomUtilisateur_txt.setText("");
  mdp_txt.setText("");
  role_txt.setText("");
}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nom_txt = new javax.swing.JTextField();
        prenom_txt = new javax.swing.JTextField();
        nomUtilisateur_txt = new javax.swing.JTextField();
        mdp_txt = new javax.swing.JPasswordField();
        enregistrer = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        role_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestionbibliotheque/img/fich.png"))); // NOI18N
        jLabel1.setText("Gestion De Bibliotheque");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inscription Utilisateur");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nom");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Prenom");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nom d'utilisateur");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mot de Passe");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Role");

        enregistrer.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        enregistrer.setText("Enregistrer");
        enregistrer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));
        enregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enregistrerActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton2.setText("Annuler");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nom_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(nomUtilisateur_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(mdp_txt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenom_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(role_txt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nom_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prenom_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nomUtilisateur_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(mdp_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(role_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enregistrer)
                    .addComponent(jButton2))
                .addGap(0, 55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enregistrerActionPerformed
    
  // Vérifier l'autorisation du superUtilisateur
boolean superUtilisateurAutorise = false;
String motDePasseSuperUtilisateur = "Passer01"; // Mot de passe du superUtilisateur
String motDePasse = String.valueOf(mdp_txt.getPassword());

              if (motDePasse.length() < 8) {
            JOptionPane.showMessageDialog(this, "Le mot de passe doit contenir au moins 8 caractères");
            return;
        }
if (motDePasse.equals(motDePasseSuperUtilisateur)) {
    superUtilisateurAutorise = true;
}


// Si l'autorisation n'est pas accordée, afficher un message et quitter la méthode
if (!superUtilisateurAutorise) {
    JOptionPane.showMessageDialog(null, "Veuillez attendre l'autorisation du superUtilisateur.");
    return;
}
if (!testFied( prenom_txt.getText(), nom_txt.getText(),role_txt.getText(),nomUtilisateur_txt.getText())){
    JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
                     return;
                 }
                 // pour recuperer les valeurs des champs du formulaire
 
    String nom = nom_txt.getText();
    String prenom = prenom_txt.getText();
    String nomUtilisateur = nomUtilisateur_txt.getText();
    String role = role_txt.getText();
                

                 if (nom.length() < 2) {
                     JOptionPane.showMessageDialog(this, "Le nom doit avoir au minimum 2 lettres !", "Input Error", JOptionPane.ERROR_MESSAGE);
                     return;
                 }
                 if (prenom.length() < 2) {
                     JOptionPane.showMessageDialog(this, "Le prenom doit avoir au minimum 2 lettres", "Input Error", JOptionPane.ERROR_MESSAGE);
                     return;
                 }

                  if (verifieNomUtilisateur(nomUtilisateur)) {
            JOptionPane.showMessageDialog(this, "L'email existe déjà !");
            return;    
        }

   


//// Récupération des valeurs des champs
//    String nom = nom_txt.getText();
//    String prenom = prenom_txt.getText();
//    String nomUtilisateur = nomUtilisateur_txt.getText();
//    //String motDePasse = String.valueOf(mdp_txt.getPassword());
//    String role = role_txt.getText();
    
    // Création d'un nouvel utilisateur
    Utilisateurs utilisateur = new Utilisateurs( nomUtilisateur, motDePasse,  role);
    
    utilisateur.setNomUtilisateur(nomUtilisateur);
    utilisateur.setMotDePasse(motDePasse);
    utilisateur.setRole(role);
    
    // Ajouter l'utilisateur à la base de données
    utilisateur = iuser.ajouterUtilisateur(utilisateur);
     if (utilisateur == null) {
        JOptionPane.showMessageDialog(null, "Erreur lors de l'insertion de l'utilisateur");
        return;
    }else{
    JOptionPane.showMessageDialog(null, "insertion reussi");

     }
      // Créer une nouvelle inscription
    Inscription inscription = new Inscription();
    inscription.setDateInscription(new Date());
    inscription.setStatut("ACCEPTÉ");


    // Ajouter l'utilisateur à l'inscription
    inscription.setUtilisateursId(utilisateur);

    // Ajouter l'inscription à la base de données
    Inscription inscrire = iInscription.addInscription(inscription);
    if (inscrire.getId() == null) {
        JOptionPane.showMessageDialog(null, "Erreur lors de l'insertion de l'inscription");
        return;
    }else{
          JOptionPane.showMessageDialog(null, "inscription  reussi");
    }
 
    }//GEN-LAST:event_enregistrerActionPerformed

  
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUtilisateur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enregistrer;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField mdp_txt;
    private javax.swing.JTextField nomUtilisateur_txt;
    private javax.swing.JTextField nom_txt;
    private javax.swing.JTextField prenom_txt;
    private javax.swing.JTextField role_txt;
    // End of variables declaration//GEN-END:variables

   private boolean testFied(String prenom, String nom, String role, String nomUtilisateur) {
    return !(prenom.trim().isEmpty()
            || nom.trim().isEmpty()
            || role.trim().isEmpty()
             || nomUtilisateur.trim().isEmpty()); 
}

    private boolean verifieNomUtilisateur(String nomUtilisateur) {
         EntityTransaction transaction = EM.getTransaction();
    transaction.begin();
    TypedQuery<Long> query = EM.createQuery("SELECT COUNT(u) FROM Utilisateur u WHERE u.nom_utilisateur = :username", Long.class);
    query.setParameter("username", nomUtilisateur);
    Long count = query.getSingleResult();
    transaction.commit();
    if (count > 0) {
        System.out.println("Le nom d'utilisateur existe déjà");
        return false;
    } else {
        return true;
    }
    }
}
