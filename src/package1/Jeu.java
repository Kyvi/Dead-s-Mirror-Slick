package package1;

import metier.Forge;
import metier.Metier;
import metier.Rocher;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.ResourceLoader;

import Combat.Attaque;
import Combat.BattlePlayer;
import Combat.Boss;
import Graphisme.Dialogue;
import Graphisme.Map;
import Menu.BattreMonstre;
import Menu.Inventaire;
import Menu.InventaireGameState;
import Menu.JournalQuete;
import Menu.MenuGameState;
import Menu.Objet;
import Menu.ObjetUtilisable;
import Menu.ParlerAQq;
import Menu.Quete;
import Menu.RamenerObjet;
import Non_Combattant.DonneurQuete;
import Non_Combattant.ExpertMetier;
import Non_Combattant.Marchand;
import Non_Combattant.Personne;
import Non_Combattant.PersonneNormale;
import Principal.BattleGameState;
import Principal.Splash;

public class Jeu extends BasicGameState implements ComponentListener {

	

	
	//autres
	 private int i=0;
	 private int switchzone = 5;
	 private int affichage = 0;
	 private boolean bossencounter = false;
	private StateBasedGame game;
	private double proba;
	private long debut;
	private int nombreEM;
	private int nombreDQ;
	private int nombreMarch;
	private Sound beep;
	private Sound launch;
	private Sound musiclave;
	private Music battle;
	private Splash splash;
	 
	
	private Music mzone1;
	private Music mzone2;
	private Music mzone3;
	private Music mzone4;
	private Music mzone5;
	private Music mzone6;
	private Music mzone7;
	private Music mb1;
	private Music mb2;
	private Music mb3;
	private Music mb4;
	private Music mend;
	

	private Music battleboss;
	private TrueTypeFont font2;
	  private boolean antiAlias = true;
	private Image carte;
	public static final int ID = 2;
	private GameContainer container;
	 private static String titre="Dead's Mirror";
	 
	//cration map
	private Map map=new Map();
	//creation objets
	// Potion
	private ObjetUtilisable café = new ObjetUtilisable("Café", 0,50, false, 30,0,0,0);
	private ObjetUtilisable antidote = new ObjetUtilisable("Antidote", 1,100, false, 60,0,0,0);
	private ObjetUtilisable lait = new ObjetUtilisable("Lait", 2,200, false, 100,0,0,0);
	private ObjetUtilisable limonade = new ObjetUtilisable("Limonade", 3,400, false, 150,0,0,0);
	private ObjetUtilisable RedBull = new ObjetUtilisable("RedBull", 4,800, false, 220,0,0,0);
	// Mana
	private ObjetUtilisable croissant = new ObjetUtilisable("Croissant", 5,50, false, 0,50,0,0);
	private ObjetUtilisable banane = new ObjetUtilisable("Banane", 6,100, false, 0,100,0,0);
	private ObjetUtilisable biscotte = new ObjetUtilisable("Biscotte", 7,200, false, 0,200,0,0);
	private ObjetUtilisable speculos = new ObjetUtilisable("Speculos", 8,400, false, 0,350,0,0);
	private ObjetUtilisable concombre = new ObjetUtilisable("Concombre", 9,800, false, 0,500,0,0);
	// Attaque
	private ObjetUtilisable orange = new ObjetUtilisable("Orange", 10,50, false, 0,0,5,0);
	private ObjetUtilisable huile = new ObjetUtilisable("Huile", 11,100, false, 0,0,10,0);
	private ObjetUtilisable viande = new ObjetUtilisable("Viande", 12,200, false, 0,0,20,0);
	private ObjetUtilisable miel = new ObjetUtilisable("Miel", 13,400, false, 0,0,30,0);
	private ObjetUtilisable kinder = new ObjetUtilisable("Kinder", 14,800, false, 0,0,40,0);
	// Defense
	private ObjetUtilisable doliprane = new ObjetUtilisable("Doliprane", 15,50, false, 0,0,0,5);
	private ObjetUtilisable gants = new ObjetUtilisable("Gants", 16,100, false, 0,0,0,10);
	private ObjetUtilisable pansement = new ObjetUtilisable("Pansement", 17,200, false, 0,0,0,20);
	private ObjetUtilisable déodorant = new ObjetUtilisable("Déodorant", 18,400, false, 0,0,0,30);
	private ObjetUtilisable masque = new ObjetUtilisable("Masque", 19,800, false, 0,0,0,40);
	// Pioche
	private Equipable pioche1 = new Equipable("Pioche en bois", 20,100,false,7,0,0,0,2);
	private Equipable pioche2 = new Equipable("Pioche en fer", 21,200,false,15,0,0,0,2);
	private Equipable pioche3 = new Equipable("Pioche en diamant", 22,500,false,30,0,0,0,2);
	// Epee
	private Equipable couteau = new Equipable("Couteau", 23,100,false,7,0,0,5,2);
	private Equipable sabre = new Equipable("Sabre", 24,200,false,15,0,0,10,2);
	private Equipable revolver = new Equipable("Revolver", 25,500,false,25,30,0,20,2);
	private Equipable laser = new Equipable("Sabre laser", 26,1000,false,35,100,0,30,2);
	private Equipable bazooka = new Equipable("Bazooka", 27,2000,false,45,220,30,40,2);
	// Casque
	private Equipable audio = new Equipable("Casque audio", 28,100,false,7,0,0,5,0);
	private Equipable casquette = new Equipable("Casquette", 29,200,false,10,0,10,0,0);
	private Equipable bonnet = new Equipable("Bonnet", 30,500,false,20,0,20,5,0);
	private Equipable pompier = new Equipable("Casque de pompier", 31,1000,false,30,0,30,30,0);
	private Equipable pointe = new Equipable("Casque à pointe", 32,2000,false,40,100,40,40,0);
	private Equipable heaume = new Equipable("Heaume", 33,4000,false,50,220,50,50,0);
	// Armure
	private Equipable combi = new Equipable("Combinaison", 34,100,false,7,30,0,0,1);
	private Equipable cape = new Equipable("Cape d'invisibilité", 35,10000,true,7,0,0,0,1);
	private Equipable plastron = new Equipable("Plastron", 36,200,false,10,60,20,0,1);
	private Equipable cotte = new Equipable("Cotte de maille", 37,500,false,20,100,5,0,1);
	private Equipable peau = new Equipable("Peau de loup", 38,1000,false,30,150,30,0,1);
	private Equipable gilet = new Equipable("Gilet pare balle", 39,2000,false,40,220,50,30,1);
	// Autre
	private Objet pierre = new Objet("Pierre", 40,10,false);
	private Objet fer = new Objet("Fer", 41,20,false);
	private Objet diamant = new Objet("Diamant", 42,100,false);
	private Objet obcarte = new Objet("Carte", 43,10000,true);
	private Objet doudou = new Objet("Doudou", 44,10000,true);
	private Objet propulseur = new Objet("Propulseur", 45,10000,true);
	private Objet clé = new Objet("Clé d'accès", 46,10000,true);
	private Objet miroir = new Objet("Dead's Mirror", 47,10000,true);
	private Objet boule = new Objet("Boule magique",48,10000,true);
	private Objet livre1 = new Objet("Et si c'était vrai",49,1000,false);
	private Objet livre2 = new Objet("Programmer en Java",50,1000,false);
	private Objet livre3 = new Objet("Scarlett",51,1000,false);
	
	
	
	
	
	
	
	private Objet recq1[] ={couteau,audio,combi};
	private Objet recq2[] = {obcarte};
	private Objet recq3[] = {antidote,gants};
	private Objet recq4[] = {casquette};
	private Objet recq5[] = {croissant,lait};
	private Objet recq6[] = {sabre};
	private Objet recq7[] = {cape};
	private Objet recq8[] = {clé};
	private Objet obj[]=new Objet[70];
	private Objet tabObjMarch[] = {café,antidote,lait,limonade,RedBull,croissant,banane,biscotte,speculos,concombre,
						orange,huile,viande,miel,kinder,doliprane,gants,pansement,déodorant,masque,
						pioche1,pioche2,pioche3,couteau,sabre,revolver,laser,bazooka,audio,casquette,
						bonnet,pompier,pointe,heaume,combi,plastron,cotte,peau,gilet,pierre,
						fer,diamant, livre1, livre2, livre3};
								
	
	private int tabObjBoss1 []={45};
	private int tabObjBoss2 []={44};
	private int tabObjBoss3 []={48};
	private int tabObjBoss4 []={47};
	private int tabRamObj1[][]={{0,5,10},
							   {1,1,1}};
	private int tabRamObj2[][]={{44},
								{1}};
	private int tabRamObj3[][]={{49,50,51},
								{1,1,1}};
	private int tabRamObj4[][]={{48},
								{1}};
	
    private Inventaire inv=new Inventaire(70,obj);
	//creation quete
	private ParlerAQq q1 = new ParlerAQq(1,"Parler au Maire", "Aller parler au Maire de Mésomorphe",
				1,recq1, 3,100,15, 15);
	private RamenerObjet q2 = new RamenerObjet(2,"Petit déjeuner Veilleur", "Ramener un café, un croissant et une orange pour que le veilleur de nuit puisse petit déjeuner.",
				0,recq2, 1,200,0, tabRamObj1,3,inv);
	private BattreMonstre q3 = new BattreMonstre(3,"Battre trois Gastons","Promeneur Germin est en panique. Débarrasez le terrain de 3 Gastons pour lui.",2,recq3,2,400,1,1,3);
	private ParlerAQq q4 = new ParlerAQq(4,"Parler a petite-fille Julia", "Grand-mère Mathilda s'inquiète pour sa petite fille, il faut aller la voir à Mésomorphe",
				1,recq4, 1,600,16, 16);
	private RamenerObjet q5 = new RamenerObjet(5,"Ramener le doudou", "Petite fille Charlène s'est faite voler son doudou par un mystérieux inconnu. Il faut aller le battre pour le récuperer.",
			0,recq5, 2,900,0, tabRamObj2,1,inv);
	private BattreMonstre q6 = new BattreMonstre(6,"Battre deux loups","Grand frère Justin a faim. Il doit ramener deux loups de la terre dévastée pour manger avec sa petite soeur Charlène.",2,recq6,1,1200,15,15,2);
	private RamenerObjet q7 = new RamenerObjet(7,"Ramener trois livres", "La bibliothécaire a besoin de Scarlett, Programmer en Java, et Et si c'était vrai en urgence.",
			0,recq7, 1,1600,0, tabRamObj3,3,inv);
	private RamenerObjet q8 = new RamenerObjet(8,"Ramener la boule magique", "La prêtresse du village de Utopia s'est faite voler sa boule magique par un abruti. Il faut aller le battre pour la récuperer.",
			0,recq8, 1,2000,0, tabRamObj4,1,inv);
	private RamenerObjet q9 = new RamenerObjet(9,"Ramener la boule magique", "La prêtresse du village de Utopia s'est faite voler sa boule magique par un abruti. Il faut aller le battre pour la récuperer.",
			0,recq8, 1,2000,0, tabRamObj4,1,inv);
	
	
	private Quete tabq[]={q1,q2,q3,q4,q5,q6,q7,q8,q9};
	private JournalQuete jq=new JournalQuete(tabq,9);
	//creation rocher
    private Rocher rocher1=new Rocher(7,2,40,400);
    private Rocher rocher2=new Rocher(7,3,40,400);
    private Rocher rocher3=new Rocher(7,4,40,400);
    private Rocher rocher4=new Rocher(7,5,40,400);
    private Rocher rocher5=new Rocher(15,2,41,1000);
    private Rocher rocher6=new Rocher(15,3,41,1000);
    private Rocher rocher7=new Rocher(15,4,41,1000);
    private Rocher rocher8=new Rocher(15,5,41,1000);
    private Rocher rocher9=new Rocher(30,2,42,2000);
    private Rocher rocher10=new Rocher(30,3,42,2000);
    private Rocher rocher11=new Rocher(30,4,42,2000);
    private Rocher rocher12=new Rocher(30,5,42,2000);
	 private int tabrocher[][];
	 private Rocher roch[];
    //creation forge
	 private Objet tabcreation[][]={{pierre,café},
                                    {fer,biscotte},
                                    {diamant,kinder},
                                    {pierre,croissant},
                                    {viande,fer},
                                    {masque,diamant},
                                    {orange,pierre},
                                    {pansement,fer},
                                    {doliprane,pierre},
                                    {RedBull,diamant}};
	 private Equipable tabcree[]={couteau,revolver,bazooka,audio,bonnet,heaume,plastron,peau,combi,gilet};
	 private int niveaureq[]={7,15,30,7,15,30,7,15,7,30};
	 private int expobtenue[]={400,1000,2000,400,1000,2000,400,1000,400,2000};
	 private Forge forge=new Forge(10,tabcreation,tabcree,niveaureq,expobtenue);
	 private int tabforge[][];
	 private Forge forg[];
    //creation equipement
	private Equipement equipement=new Equipement();
	//creation metier
	private Metier metier=new Metier(0,"Aucun",15,0,1000);
	//creation joueur
	private Joueur player = new Joueur(map,this,jq,inv,metier,equipement);
	private Attaque brise=new Attaque("Légère brise",15,0,10,7);
	private Attaque flamme=new Attaque("Lance-flamme",18,1,30,10);
	private Attaque eclair=new Attaque("Eclair",21,2,50,15);
	private Attaque blizzard=new Attaque("Blizzard",24,3,70,20);
	private Attaque tornade=new Attaque("Tornade",27,4,100,25);
	private Attaque pluie=new Attaque("Averse",30,5,150,30);
	private Attaque deflagration=new Attaque("Deflagration",33,6,200,35);
	private Attaque tsunami=new Attaque("Tsunami",36,7,250,40);
	private Attaque poing=new Attaque("Coup de poing",15,8,10,7);
	private Attaque pied=new Attaque("Pied vengeur",18,9,30,10);
	private Attaque massue=new Attaque("Massue mortelle",21,10,50,15);
	private Attaque doublepied=new Attaque("Double pied",24,11,70,20);
	private Attaque combo=new Attaque("Combo poing",27,12,100,25);
	private Attaque belier=new Attaque("Bélier sauvage",30,13,150,30);
	private Attaque destruction=new Attaque("Destruction",33,14,200,35);
	private Attaque cataclysme=new Attaque("Cataclysme",36,15,250,40);
	private Attaque tabmag[]={brise,flamme,eclair,blizzard,tornade,pluie,deflagration,tsunami};
	private Attaque tabguer[]={poing,pied,massue,doublepied,combo,belier,destruction,cataclysme};
	private BattlePlayer bplayer = new BattlePlayer(player,tabmag,tabguer);
	 private Camera camera = new Camera(player);
	//creation fenetre inventaire
    private InventaireGameState InvGaSt=new InventaireGameState(this,inv,jq,player,equipement);
    //creation des dialogues
    private String maire[]={"Le maire : Comment vas tu mon enfant ?","Moi : Une catastrophe s'est produite, le miroir a été volé !!","Le maire : Tout s'explique, hier soir j'ai entendu des bruits susptects dans la ville, il faut retrouver le miroir."};
    private String julia[]={"Julia : Cette nuit il y a eu un bruit horrible, j'ai eu très peur.","Moi : T'inquiète pas, ça va aller mon enfant.","Julia : Il faut que je prévienne ma grand mère."};
    private String william[]={"William : Tu n'aurais pas vu mon chien par hasard ? Il s'appelle Alfred. Je l'ai perdu depuis plusieurs heures."};
    private String vincent[]={"Vincent : Ils sont bizarres ces cailloux, j'en avais jamais vu des comme ça"};
    private String joanna[]={"Joanna : Il fait vachement chaud ici, j'aurais pas dû prendre autant de pull"};
    private String papa1[]={"Papa : Bonjour toi, comment vas tu ?","Moi : Papa, le miroir a été volé, je ne sais pas quoi faire !","Papa : Mon dieu c'est horrible, tu devrais aller prévenir le maire."};
    private String papa2[]={"Papa : Alors, es tu allé le voir ?","Moi : Non, je ne l'ai pas encore trouvé.","Papa : Continue de chercher alors."};
    private String papa3[]={"Papa : Alors, que t'as t-il dit ?","Moi : Hier, il a entendu des bruits, quelqu'un s'en est bel et bien emparé","Papa : Tu devrais essayer de le retrouver, prend cet équipement avec toi."};
    private String papa4[]={"Papa : Tu devrais aller voir le veilleur de nuit, il a peut-être vu quelque chose","Moi : C'est une bonne idée papa merci.",""};
    private String veilleur0[]={"Veilleur de nuit : Quelle nuit ! Je meurs de faim."};
    private String veilleur1[]={"Veilleur de nuit : Bonjour mon enfant, tu n'aurais pas à manger par hasard ?","Moi : Je vais vous chercher ça de suite","Veilleur de nuit : Un café, un croissant, un orange s'il te plait."};
    private String veilleur2[]={"Veilleur de nuit : Ca y est, tu as mon petit déjeuner ?","Moi : Non pas encore. J'y vais de ce pas",""};
    private String veilleur3[]={"Veilleur de nuit : Ah merci bien mon jeune ami, Parait-il que tu pars à l'aventure ? Tu devrais prendre cette carte avec toi.","",""};
    private String veilleur4[]={"Veilleur de nuit : Hier j'ai vu quelque chose de très étrange dans la cour. Une ombre entourée de fumée violette... Cette personne avait vraiment l'air louche.","",""};
    private String germin0[]={""};
    private String germin1[]={"Germin : Au secours, au secours ! Les créatures m'attaquent.","Moi : Je vais vous aider ne bougez pas.","Germin : Très bien j'attend alors."};
    private String germin2[]={"Germin : Il y en a un qui me grimpe à la jambe","Moi : J'ai presque fini, un instant",""};
    private String germin3[]={"Germin : Ah merci bien, j'ai eu très peur","Moi : Il n'y a pas de problème, c'est normal.",""};
    private String germin4[]={"Germin : Depuis cette nuit, les créatures sont devenues très agressives, cela doit être la faute de cette femme !","",""};
    private String mathilda0[]={"Mathilda : J'ai fait un drôle de rêve cette nuit, ma maison prenait feu et je dansais à travers les flammes."};
    private String mathilda1[]={"Mathilda : Je m'inquiète, ma petite fille Julia est chez une copine et je n'ai pas de nouvelles.","Moi : Dans quelle ville se trouve t-elle ?","Mathilda : Elle est à Mésomorphe, paraît-il qu'il y a eu un vol là-bas."};
    private String mathilda2[]={"Mathilda : Vous l'avez vu ? Elle va bien ?","",""};
    private String mathilda3[]={"Moi : Je viens de voir votre petite fille, elle est apeurée à cause des évènements d'hier, mais elle va bien.","Mathilda : Oh grand Dieu, merci beaucoup pour votre aide",""};
    private String mathilda4[]={"Mathilda : Des amis à moi pensent que cette femme est celle qui ravageait des contrées avec son mari, il y a bien longtemps. Parait-il qu'elle était capable d'apparaître et de disparaître au milieu d'une fumée violette","",""};
    private String charlene0[]={"Charlène : J'aime la bonne odeur qu'il y a dans cette ville le matin"};
    private String charlene1[]={"Charlène : On m'a volé mon doudou, c'était un vilain grand monsieur et il est parti dans la fôret des lilas.","Moi : Je vais voir ce que je peux faire ma puce.",""};
    private String charlene2[]={"Charlène : Vous avez retrouvé mon doudou ? Il était à ma maman...","",""};
    private String charlene3[]={"Moi : Tiens, voilà ton doudou, le méchant monsieur ne reviendra plus.","Charlène : Merci beaucoup, vous avez sauvez monsieur Dodo.",""};
    private String charlene4[]={"Charlène : Je commence à m'inquiéter, mon grand frère est parti chasser, et n'est toujours pas revenu, il m'a dit qu'il serait là pour midi.","",""};
    private String justin0[]={"Justin : Les loups sont tenaces aujourd'hui, je n'ai pas pu en tuer un seul depuis ce matin."};
    private String justin1[]={"Justin : Il est plus de midi, ma petite soeur va s'inquiéter, vous pourriez m'aider à attraper 2 loups ?","Moi : Bien sûr je vais voir ce que je peux faire.",""};
    private String justin2[]={"Justin : Vous avez réussi ?","",""};
    private String justin3[]={"Moi : Tu as raison, ils sont vigoureux aujourd'hui, mais voici les deux bêtes.","Justin : Merci mille fois, je vais enfin pouvoir rentrer chez moi.",""};
    private String justin4[]={"Justin : J'ai entendu dire que vous cherchiez le miroir, la bibliothécaire de Utopia pourra sûrement vous aider.","",""};
    private String biblio0[]={"Bibliothécaire : Il va sûrement pleuvoir cet après-midi, le ciel se couvre."};
    private String biblio1[]={"Bibliothécaire : J'ai désespérément besoin de 3 livres, pourriez vous m'aider ?","Moi : Oui bien sûr. Quels sont les titres ?","Bibliothécaire : Et si c'était vrai,Programmer en Java,Scarlett"};
    private String biblio2[]={"Bibliothécaire : Les avez vous trouvé ? Je suis sure qu'un marchand pourra vous aider.","",""};
    private String biblio3[]={"Moi : Voilà les 3 livres que vous vouliez.","Bibliothécaire : Merci beaucoup pour votre aide, vous me sauvez la vie",""};
    private String biblio4[]={"Bibliothécaire : La femme que vous cherchez s'appelle Mirrathia et son défunt mari s'appelle Keldranor. Elle avait juré il y a des années, qu'elle se vengerait après avoir ramené son mari à la vie. Soyez prudent.","",""};
    private String pretresse0[]={"Prêtresse : Il fera beau cet après midi, c'est moi qui vous le dit."};
    private String pretresse1[]={"Prêtresse : Un abruti vient de me prendre ma boule magique, comme s'il savait s'en servir... Votre aide serait la bienvenue mon ami","",""};
    private String pretresse2[]={"Prêtresse : Je peux sentir que vous ne l'avez pas encore eu cette crapule. Je compte sur vous.","",""};
    private String pretresse3[]={"Prêtresse : Merci pour ce service, les esprits vous le rendront","",""};
    private String pretresse4[]={"Prêtresse : Ooooh je vois quelque chose... Un grand combat va s'élever, un jeune habitant de Mésomorphe contre deux âme-soeurs vont s'affronter","",""};
    
    
    
    
	 private Dialogue dial=new Dialogue();
	 //creation des personnes
	 private PersonneNormale p1=new PersonneNormale(15,"Le maire",maire,3,2,2367,1658);
	 private PersonneNormale p2 = new PersonneNormale(16,"Petite-fille Julia",julia,3,2,1906,1967);
	 private PersonneNormale p3 = new PersonneNormale(17,"William",william,1,2,3338,2515);
	 private PersonneNormale p4 = new PersonneNormale(18,"Vincent",vincent,1,2,2006,3227);
	 private PersonneNormale p5 = new PersonneNormale(19,"Joanna",joanna,1,2,3072,4379);
	 private ExpertMetier ex1=new ExpertMetier(10,"Michel",joanna,1,2,4570,1646,player);
	 private ExpertMetier ex2=new ExpertMetier(11,"Sylvie",joanna,1,2,3035,3216,player);
	 private Marchand m1=new Marchand(12,"Sébastien",joanna,1,2,2202,1743,tabObjMarch,45);
	 private Marchand m2=new Marchand(13,"Jean-Luc",joanna,1,2,4134,1939,tabObjMarch,45);
	 private Marchand m3=new Marchand(14,"Romane",joanna,1,2,3267,3248,tabObjMarch,45);
	 private DonneurQuete dq9=new DonneurQuete(9,"Bibliothécaire",biblio0,1,2,100,200,biblio1,biblio2,biblio3,biblio4,0,3,null,q9,8);
	 private DonneurQuete dq8=new DonneurQuete(8,"Prêtresse",pretresse0,1,2,3165,3599,pretresse1,pretresse2,pretresse3,pretresse4,0,3,dq9,q8,7);
	 private DonneurQuete dq7=new DonneurQuete(7,"Bibliothécaire",biblio0,1,2,3165,3112,biblio1,biblio2,biblio3,biblio4,0,3,dq8,q7,6);
	 private DonneurQuete dq6=new DonneurQuete(6,"Grand-frère Justin",justin0,1,2,4558,3259,justin1,justin2,justin3,justin4,0,3,dq7,q6,5);
	 private DonneurQuete dq5=new DonneurQuete(5,"Petite-fille Charlène",charlene0,1,2,4481,1936,charlene1,charlene2,charlene3,charlene4,0,3,dq6,q5,4);
	 private DonneurQuete dq4=new DonneurQuete(4,"Grand-mère Mathilda",mathilda0,1,2,4349,1666,mathilda1,mathilda2,mathilda3,mathilda4,0,3,dq5,q4,3);
	 private DonneurQuete dq3=new DonneurQuete(3,"Promeneur Germin",germin0,1,2,2924,1575,germin1,germin2,germin3,germin4,0,3,dq4,q3,2);
	 private DonneurQuete dq2=new DonneurQuete(2,"Veilleur de nuit",veilleur0,1,2,2637,1562,veilleur1,veilleur2,veilleur3,veilleur4,0,3,dq3,q2,1);
	 private DonneurQuete dq1=new DonneurQuete(1,"Papa",veilleur0,1,2,2678,2030,papa1,papa2,papa3,papa4,0,3,dq2,q1,0);
	 private int tabperso[][];
	 private Personne perso[];
	 private Marchand marchand[];
	 private DonneurQuete donneurq[];
	 private ExpertMetier exmetier[];
	 // creation des boss
	 private Boss b1= new Boss(21,12,"César",tabObjBoss1,1,1000,1000,3967,1875,this,false);
	 private Boss b2= new Boss(22,20,"DNAngel",tabObjBoss2,1,2000,2000,3698,3194,this,false);
	 private Boss b3= new Boss(23,26,"Ezio",tabObjBoss3,1,2500,2500,1983,2491,this,false);
	 private Boss b4= new Boss(24,40,"M & K",tabObjBoss4,1,5000,5000,4650,4482,this,true);
	 private Boss b5= new Boss(25,40,"M & K",tabObjBoss4,1,5000,5000,100,100,this,true);
	 private Boss boss[];
	 private int tabboss[][];
	 private int numboss=0;
	 
	 public Jeu(Splash s){
		 splash = s;
	 }
	 
	 public void init(GameContainer container,StateBasedGame game) throws SlickException {
		 int i,j;
		 /*tabObjMarch[0]=champignon;
		 tabObjMarch[1]=Pierre;
		 tabObjMarch[2]=eq20;
		 tabObjMarch[3]=cuivre;*/
		 
		 //  inv.PlacerObjet(47, 1, jq);
		  inv.settableauObjet(0, café);
		  inv.settableauObjet(1, antidote);
		  inv.settableauObjet(2, lait);
		  inv.settableauObjet(3, limonade);
		  inv.settableauObjet(4, RedBull);
		  inv.settableauObjet(5, croissant);
		  inv.settableauObjet(6, banane);
		  inv.settableauObjet(7, biscotte);
		  inv.settableauObjet(8, speculos);
		  inv.settableauObjet(9, concombre);
		  inv.settableauObjet(10, orange);
		  inv.settableauObjet(11, huile);
		  inv.settableauObjet(12, viande);
		  inv.settableauObjet(13, miel);
		  inv.settableauObjet(14, kinder);
		  inv.settableauObjet(15, doliprane);
		  inv.settableauObjet(16, gants);
		  inv.settableauObjet(17, pansement);
		  inv.settableauObjet(18, déodorant);
		  inv.settableauObjet(19, masque);
		  inv.settableauObjet(20, pioche1);
		  inv.settableauObjet(21, pioche2);
		  inv.settableauObjet(22, pioche3);
		  inv.settableauObjet(23, couteau);
		  inv.settableauObjet(24, sabre);
		  inv.settableauObjet(25, revolver);
		  inv.settableauObjet(26, laser);
		  inv.settableauObjet(27, bazooka);
		  inv.settableauObjet(28, audio);
		  inv.settableauObjet(29, casquette);
		  inv.settableauObjet(30, bonnet);
		  inv.settableauObjet(31, pompier);
		  inv.settableauObjet(32, pointe);
		  inv.settableauObjet(33, heaume);
		  inv.settableauObjet(34, combi);
		  inv.settableauObjet(35, cape);
		  inv.settableauObjet(36, plastron);
		  inv.settableauObjet(37, cotte);
		  inv.settableauObjet(38, peau);
		  inv.settableauObjet(39, gilet);
		  inv.settableauObjet(40, pierre);
		  inv.settableauObjet(41, fer);
		  inv.settableauObjet(42, diamant);
		  inv.settableauObjet(43, obcarte);
		  inv.settableauObjet(44, doudou);
		  inv.settableauObjet(45, propulseur);
		  inv.settableauObjet(46, clé);
		  inv.settableauObjet(47, miroir);
		  inv.settableauObjet(48,boule);
		  inv.settableauObjet(49, livre1);
		  inv.settableauObjet(50, livre2);
		  inv.settableauObjet(51,livre3);
		  splash.getsp().setobjets();
		  splash.getsp().repaint();
		  
		  
		 
		 this.container = container;
		 carte = new Image("/src/package1/ressources/map/carte_jeu.png").getScaledCopy(4750, 4470);
		 container.setMouseCursor(new Image("/src/package1/ressources/hud/curseur.png"), 0, 0);
		 beep=new Sound("/src/package1/ressources/music/beep.wav");
		 launch=new Sound("/src/package1/ressources/music/launch.wav");
		 
		 mzone1 = new Music("/src/package1/ressources/music/jeu.ogg");
		 mzone2 = new Music("/src/package1/ressources/music/eowyn.ogg");
		 mzone3 = new Music("/src/package1/ressources/music/worms.ogg");
		 mzone4 = new Music("/src/package1/ressources/music/dis.ogg");
		 splash.getsp().setmusiquesvilles();
		  splash.getsp().repaint();
		 mzone5 = new Music("/src/package1/ressources/music/naissance.ogg");
		 mzone6 = new Music("/src/package1/ressources/music/town.ogg");
		 mzone7 = new Music("/src/package1/ressources/music/saru.ogg");
		 splash.getsp().setmusiqueszones();
		  splash.getsp().repaint();
		 battle =new Music("/src/package1/ressources/music/battle.ogg");
		 mb1 = new Music("/src/package1/ressources/music/bossbattle.ogg");
		 mb2 = new Music("/src/package1/ressources/music/battle2.ogg");
		 mb3 = new Music("/src/package1/ressources/music/c4final.ogg");
		 mb4 = new Music("/src/package1/ressources/music/time.ogg");
		 mend = new Music("/src/package1/ressources/music/end.ogg");
		 splash.getsp().setmusiques();
		  splash.getsp().repaint();
		 try {
				InputStream inputStream	= ResourceLoader.getResourceAsStream("/src/package1/ressources/Font/immortal/IMMORTAL.ttf");
				Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
	            awtFont2 = awtFont2.deriveFont(32f); // set font size
	            font2 = new TrueTypeFont(awtFont2, antiAlias);
				 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 this.game=game;
		  this.map.init();
		  this.player.init(this.game);
		  this.bplayer.init();
		  this.dial.init();
		  this.p1.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/homme3.png",32,48 ));
		  this.p2.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/fille7.png",32,48 ));
		  this.p3.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/homme11.png",32,48 ));
		  this.p4.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/homme6.png",32,48 ));
		  this.p5.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/fille9.png",32,48 ));
		  
		  this.dq1.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/homme2.png",32,48 ));
		  this.dq2.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/homme5.png",32,48 ));
		  this.dq3.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/homme8.png",32,48 ));
		  this.dq4.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/fille3.png",32,48 ));
		  this.dq5.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/fille6.png",32,48 ));
		  this.dq6.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/homme10.png",32,48 ));
		  this.dq7.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/fille6.png",32,48 ));
		  this.dq8.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/pretresse.png",32,48 ));
		  this.dq9.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/homme3.png",32,48 ));
		  
		  this.m1.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/homme4.png",32,48 ));
		  this.m2.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/homme4.png",32,48 ));
		  this.m3.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/homme4.png",32,48 ));
		  this.ex1.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/fille2.png",32,48 ));
		  this.ex2.init(this.game, new SpriteSheet("src/package1/ressources/Sprites/people/fille2.png",32,48 ));
		  
		  this.b1.init(this.game,new SpriteSheet("src/package1/ressources/Sprites/monsters/boss1.png", 64, 64), mb1);
		  this.b2.init(this.game,new SpriteSheet("src/package1/ressources/Sprites/monsters/boss2.png", 50, 50), mb2);
		  this.b3.init(this.game,new SpriteSheet("src/package1/ressources/Sprites/monsters/boss3.png", 32, 48), mb3);
		  this.b4.init(this.game,new SpriteSheet("src/package1/ressources/Sprites/monsters/spritefairy.png", 125, 125) ,mb4);
		  this.b5.init(this.game,new SpriteSheet("src/package1/ressources/Sprites/monsters/spritefairy.png", 125, 125),mb4);
		  
		  
		  dq1.setcompteur(1);
		  Controleur controller = new Controleur(this.player,this.game,this);
		  container.getInput().addKeyListener(controller);
		  tabperso=new int[19][2];
		  tabboss=new int[5][2];
		  tabrocher=new int[12][2]; 
		  tabforge=new int[3][2]; 
		  boss=new Boss[5];
		  roch=new Rocher[12]; 
		  forg=new Forge[3]; 
		  perso=new Personne[19]; 
		  marchand=new Marchand[3];
		  donneurq=new DonneurQuete[9];
		  exmetier=new ExpertMetier[2];
		  boss[0]=b1;
		  boss[1]=b2;
		  boss[2]=b3;
		  boss[3]=b4;
		  boss[4]=b5;
		  donneurq[0]=dq1;
		  donneurq[1]=dq2;
		  donneurq[2]=dq3;
		  donneurq[3]=dq4;
		  donneurq[4]=dq5;
		  donneurq[5]=dq6;
		  donneurq[6]=dq7;
		  donneurq[7]=dq8;
		  donneurq[8]=dq9;
		  exmetier[0]=ex1;
		  exmetier[1]=ex2;
		  perso[0]=ex1;
		  perso[1]=ex2;
		  perso[2]=dq1;
		  perso[3]=dq2;
		  perso[4]=dq3;
		  perso[5]=dq4;
		  perso[6]=dq5;
		  perso[7]=dq6;
		  perso[8]=dq7;
		  perso[9]=dq8;
		  perso[10]=dq9;
		  perso[11]=m1;
		  perso[12]=m2;
		  perso[13]=m3;
		  perso[14]=p1;
		  perso[15]=p2;
		  perso[16]=p3;
		  perso[17]=p4;
		  perso[18]=p5;
		  marchand[0]=m1;
		  marchand[1]=m2;
		  marchand[2]=m3;
		  
		  splash.getsp().setpersonnes();
		  splash.getsp().repaint();
		  
		  roch[0]=rocher1; 
		  roch[1]=rocher2; 
		  roch[2]=rocher3; 
		  roch[3]=rocher4; 
		  roch[4]=rocher5; 
		  roch[5]=rocher6; 
		  roch[6]=rocher7; 
		  roch[7]=rocher8; 
		  roch[8]=rocher9; 
		  roch[9]=rocher10; 
		  roch[10]=rocher11; 
		  roch[11]=rocher12; 
		  forg[0]=forge; 
		  forg[1]=forge; 
		  forg[2]=forge; 
		  tabboss[0][0]=3967;
		  tabboss[0][1]=1875;
		  tabboss[1][0]=3698;
		  tabboss[1][1]=3194;
		  tabboss[2][0]=1983;
		  tabboss[2][1]=2491;
		  tabboss[3][0]=4650;
		  tabboss[3][1]=4482;
		  tabboss[4][0]=100;
		  tabboss[4][1]=100;
		  tabforge[0][0]=3026;
		  tabforge[0][1]=3257; 
		  tabforge[1][0]=4620;
		  tabforge[1][1]=1682; 
		  tabforge[2][0]=2160;
		  tabforge[2][1]=1650; 
		  
		  splash.getsp().setforges();
		  splash.getsp().repaint();
		  
		  tabrocher[0][0]=3313; 
		  tabrocher[0][1]=1618; 
		  tabrocher[1][0]=3891; 
		  tabrocher[1][1]=1591; 
		  tabrocher[2][0]=4762; 
		  tabrocher[2][1]=2400; 
		  tabrocher[3][0]=4694; 
		  tabrocher[3][1]=3101; 
		  tabrocher[4][0]=2588; 
		  tabrocher[4][1]=2460; 
		  tabrocher[5][0]=1948; 
		  tabrocher[5][1]=2807; 
		  tabrocher[6][0]=2556; 
		  tabrocher[6][1]=3574; 
		  tabrocher[7][0]=2521; 
		  tabrocher[7][1]=4562; 
		  tabrocher[8][0]=3005; 
		  tabrocher[8][1]=3988; 
		  tabrocher[9][0]=3288; 
		  tabrocher[9][1]=4563; 
		  tabrocher[10][0]=4080; 
		  tabrocher[10][1]=4000; 
		  tabrocher[11][0]=4039; 
		  tabrocher[11][1]=4599; 
		  
		  splash.getsp().setrochers();
		  splash.getsp().repaint();
		  
		  tabperso [0][0]=4570;
		  tabperso[0][1]=1646;
		  tabperso[1][0]=3035;
		  tabperso[1][1]=3216;
		  tabperso[2][0]=2678;
		  tabperso[2][1]=2030;
		  tabperso[3][0]=2637;
		  tabperso[3][1]=1562;
		  tabperso[4][0]=2924;
		  tabperso[4][1]=1575; 
		  tabperso[5][0]=4349;
		  tabperso[5][1]=1666;
		  tabperso [6][0]=4481;
		  tabperso[6][1]=1936;
		  tabperso[7][0]=4558;
		  tabperso[7][1]=3259;
		  tabperso[8][0]=3165;
		  tabperso[8][1]=3112;
		  tabperso[9][0]=3165;
		  tabperso[9][1]=3599;
		  tabperso[10][0]=100;
		  tabperso[10][1]=200; 
		  tabperso[11][0]=2202;
		  tabperso[11][1]=1743;
		  tabperso [12][0]=4124;
		  tabperso[12][1]=1939;
		  tabperso[13][0]=3267;
		  tabperso[13][1]=3248;
		  tabperso[14][0]=2367;
		  tabperso[14][1]=1658;
		  tabperso[15][0]=1906;
		  tabperso[15][1]=1967;
		  tabperso[16][0]=3338;
		  tabperso[16][1]=2515; 
		  tabperso[17][0]=2006;
		  tabperso[17][1]=3227;
		  tabperso[18][0]=3072;
		  tabperso[18][1]=4379;
		  nombreEM=2;
		  nombreDQ=9;
		  nombreMarch=3;
		  
		  
		  System.out.println("Jeu initialisé");
	}
	 public int getnumboss(){
		 return numboss;
	 }
	 public void setnumboss(int i){
		 numboss=i;
	 }
	 public Boss getboss(){
		 return boss[numboss];
	 }
	 
	 public void render(GameContainer container,StateBasedGame game, Graphics g) throws SlickException {
		 this.camera.place(container, g);
		this.map.renderBackground();
		
		
		
	    this.player.render(g,dial);
	    
	    this.map.renderForeground();
	    this.p1.render(g);
	    this.p2.render(g);
	    this.p3.render(g);
	    this.p4.render(g);
	    this.p5.render(g);
	    this.ex1.render(g);
	    this.ex2.render(g);
	    this.m1.render(g);
	    this.m2.render(g);
	    this.m3.render(g);
	    this.dq1.render(g);
	    this.dq2.render(g);
	    this.dq3.render(g);
	    this.dq4.render(g);
	    this.dq5.render(g);
	    this.dq6.render(g);
	    this.dq7.render(g);
	    this.dq8.render(g);
	    this.b1.render(g,1);
	    this.b2.render(g,2);
	    this.b3.render(g,0);
	    this.b4.render(g,0);
	    this.b5.render(g, 1);
	    this.camera.render(g);
	    
	    
	    
	    
	    g.setColor(Color.red);
		g.fillRect(this.camera.getXCamera()+270, this.camera.getYCamera()-280, 110, 5);
		g.fillRect(this.camera.getXCamera()+270, this.camera.getYCamera()-175, 110, 5);
		g.fillRect(this.camera.getXCamera()+270, this.camera.getYCamera()-280, 5, 110);
		g.fillRect(this.camera.getXCamera()+375, this.camera.getYCamera()-280, 5, 110);
		g.setColor(Color.black);
		g.fillRect(this.camera.getXCamera()+275,this.camera.getYCamera()-275, 100, 100);
		Image newcarte = carte.getSubImage((int)player.getX()-1501,(int) player.getY()-1440, 1000, 1000);
		newcarte.draw(this.camera.getXCamera()+275,this.camera.getYCamera()-275, 100, 100);
		g.setColor(Color.red);
		g.fillRect(this.camera.getXCamera()+325, this.camera.getYCamera()-225, 5, 5);
		
		
		
		g.setColor(Color.white);
		
		switch(player.getzone()){
		case 1 :		 
			font2.drawString(this.camera.getXCamera()-390, this.camera.getYCamera()-300,"FORET TRANQUILLE");
					  break;
		case 2 :		 
			font2.drawString(this.camera.getXCamera()-390, this.camera.getYCamera()-300,"FORET DES LILAS");
					  break;
		case 3 :		 
			font2.drawString(this.camera.getXCamera()-390, this.camera.getYCamera()-300,"TERRE DEVASTEE");
					  break;
		case 4 :		 
			font2.drawString(this.camera.getXCamera()-390, this.camera.getYCamera()-300,"TERRE DE LAVE");
					  break;
		 case 5 :	  
		  font2.drawString(this.camera.getXCamera()-390, this.camera.getYCamera()-300,"MESOMORPHE" );
		  break;
		 case 6 :		 
				font2.drawString(this.camera.getXCamera()-390, this.camera.getYCamera()-300,"ARCANDIA");
						  break;
		 case 7 :		 
				font2.drawString(this.camera.getXCamera()-390, this.camera.getYCamera()-300,"UTOPIA");
						  break;
		 
		}
    	int k=player.getindice();
    	if(donneurq[i].getcompteur()==4){
    		i++;
    		jq.incrementei();
    		dial.setchangcompteur(1);
    	}
	    if(this.player.getvar()==1){
	    	if(player.gettype()==1){
	    		perso[k].setnotlook(false);
	    		perso[k].lookatme(player.getX(), player.getY());
	    		if(k<nombreEM){
	    			this.dial.render(g,exmetier[k],player);
	    		}else
	    		if(k>=nombreEM && k<(nombreDQ+nombreEM)) {  // attention 3 car 3 personnes normale puis donneur quete
	    			this.dial.render(g, donneurq[k-nombreEM], player);
	    		}else if(k>=(nombreDQ+nombreEM) && k<(nombreMarch+nombreDQ+nombreEM)){
	    			this.dial.render(g, marchand[k-(nombreDQ+nombreEM)], player);
	    		}
	    		else this.dial.render(g,perso[k],player);
	    	}else if(player.gettype()==2){
		    		this.dial.render(g, roch[k], player, inv);
	    	}else if(player.gettype()==3){
	    			this.dial.render(g,forg[k], player,inv,jq);
	    	}else if(player.gettype()==4){
	    		numboss=k;
	    		this.dial.render(g, boss[k], player,this);
	    	}
	    }else {
	    	perso[k].setnotlook(true);
	    	player.setarretcaillou(0);
	    	player.setarretforge(0);
	    	player.setarretrec(0);
	    	if(boss[numboss].getbattu()==0 && (boss[numboss].getcombat()==1 ||boss[numboss].getcombat()==2) ) {bossencounter = false; switchzone = 0; boss[numboss].setcombat(0);}
	    	if(boss[numboss].getbattu()==2){
	    		boss[numboss].setcombat(0);
	    		boss[numboss].setbattu(0);
	    	}
	    	donneurq[i].setcompteur(dial.getchangcompteur());
	    	if(donneurq[i].getcompteur()==3)jq.incrementei();
	    }
	 }
	 public void update(GameContainer container,StateBasedGame game, int delta) throws SlickException {
		  
		  affichage += delta;
		  this.player.update(delta);
		  this.camera.update(container);
		  this.p1.update(delta);
		  this.p2.update(delta);
		  this.p3.update(delta);
		  this.p4.update(delta);
		  this.p5.update(delta);
		  this.dq1.update(delta);
		  this.dq2.update(delta);
		  this.dq3.update(delta);
		  this.dq4.update(delta);
		  this.dq5.update(delta);
		  this.dq6.update(delta);
		  this.dq7.update(delta);
		  this.dq8.update(delta);
		  this.m1.update(delta);
		  this.m2.update(delta);
		  this.m3.update(delta);
		  this.ex1.update(delta);
		  this.ex2.update(delta);
		  
		  if(inv.getquantiteObjet(43)>0 && (map.getcalque()==5||map.getcalque()==4)){
			  map.setcalque(4);
		  }
		  if(inv.getquantiteObjet(46)>0){
			  map.setcalque(0);
		  }
		  if(inv.getquantiteObjet(45)>0){
			  
		    	player.setvitesse(0.3f);
		    }else {
		    	player.setvitesse(0.15f);
		   }
		  if(equipement.getEquipable(1)!=null){
			  if(equipement.getEquipable(1).getidObjet()==35)
		    	{proba = 0.002;} else {proba = 0.004;}}
		    else { proba = 0.004;}
		  if (inv.getquantiteObjet(45)>0){proba = proba*3;}
		    
		  
		  switch(player.getzone()){
		  case 1 :
			  
			  if (switchzone != 1) {switchzone = 0;}
			  if( switchzone == 0)
			  {	affichage = 0; mzone1.loop(); mzone1.setVolume(0f);
			  mzone1.fade(2000, 0.2f, false); switchzone = 1;}
			  break;
		  case 2 :
	  
			  if (switchzone != 2) {switchzone = 0;}
			  if( switchzone == 0)
			  {	affichage = 0; mzone2.loop(); mzone2.setVolume(0f);
			  mzone2.fade(2000, 0.5f, false); switchzone = 2;}
			  break;
		  
		  case 3 :
			  
			  if (switchzone != 3) {switchzone = 0;}
			  if( switchzone == 0)
			  {	affichage = 0; mzone3.loop(); mzone3.setVolume(0f);
			  mzone3.fade(2000, 0.4f, false); switchzone = 3;}
			  break;
		  case 4 :
			  
			  if (switchzone != 4) {switchzone = 0;}
			  if( switchzone == 0)
			  {	affichage = 0; mzone4.loop(); mzone4.setVolume(0f);
			  mzone4.fade(2000, 0.3f, false); switchzone = 4;}
			  break;
		  case 5 :
			 
			  if (switchzone != 5) {switchzone = 0;}
			  if( switchzone == 0)
			  {affichage = 0; mzone5.loop(); mzone5.setVolume(0f);
			   mzone5.fade(2000, 0.2f, false);switchzone = 5;}
			  break;
		  case 6 :
			  
			  if (switchzone != 6) {switchzone = 0;}
			  if( switchzone == 0)
			  {	affichage = 0;  mzone6.setPosition(5.5f); mzone6.loop(); mzone6.setVolume(0f);
			  mzone6.fade(2000, 0.6f, false); switchzone = 6;}
			  break;
		  	case 7 :
			  
			  if (switchzone != 7) {switchzone = 0;}
			  if( switchzone == 0)
			  {	affichage = 0; mzone7.setPosition(3);mzone7.loop(); mzone7.setVolume(0f);
			  mzone7.fade(2000, 0.6f, false); switchzone = 7;}
			  break;
		  
		  
		  }
		  if(inv.getquantiteObjet(47)>0 && (player.getvar()==0)){mend.setPosition(50);mend.loop();mend.setVolume(0f);mend.fade(3000, 1f, false);game.enterState(60,new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black,1000)); }
		  if(bossencounter){
			  
		  } 
		  if (Math.random() < proba && player.isMoving()) {
			  
			  if(player.getzone()==1){
				  
				  launch.play(1,0.2f);
				  battle.loop();
				  battle.setVolume(0f);
				  battle.fade(5000,0.2f,false);
			    game.enterState(20+(int)(Math.random()*5),new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black,1000));        
			  }else if(player.getzone()==2){
				  
				  launch.play(1,0.2f);
				  battle.loop();
				  battle.setVolume(0f);
				  battle.fade(5000,0.2f,false);
				  game.enterState(25+(int)(Math.random()*5),new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black,1000)); 
			  }else if(player.getzone()==3){
				
				  launch.play(1,0.2f);
				  battle.loop();
				  battle.setVolume(0f);
				  battle.fade(5000,0.2f,false);
				  game.enterState(30+(int)(Math.random()*5),new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black,1000));
			  }else if(player.getzone()==4){
				  
				  launch.play(1,0.2f);
				  battle.loop();
				  battle.setVolume(0f);
				  battle.fade(5000,0.2f,false);
				  game.enterState(35+(int)(Math.random()*5),new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black,1000));
			  }
		  }
	 }
	 public int getID() {
		    return ID;
	 }
	 public void keyPressed(int key,char c){
		 if(Input.KEY_M==key){
			 if (player.getMenu()==0){
			 beep.play();
			 game.enterState(MenuGameState.ID);
			 }
		 }
	 }
		 
		 
		 
		
	 
	 public void setproba(float f){
		 proba = f;
	 }
	 
	 public void setbossencounter(boolean b){
		 bossencounter = b;
	 }
	 
	 public void setswitchzone(int sz){
		 switchzone = sz;
	 }
	 public Music getMusic (){
		 return battle;
	 }
	 
	 public BattlePlayer getbp(){
		 return bplayer;
	 }
	 public Marchand getmarchand(){
		 return m1;
	 }
	 public Forge getforge(){
		 return forge;
	 }
	 public void keyReleased(int key, char c) {
		 
	 }
	 public void setdebut(long d){
		 debut=d;
	 }
	 public long getdebut(){
		 return debut;
	 }
	 public Inventaire getinventaire(){
		 return inv;
	 }
	 public JournalQuete getjq(){
		 return jq;
	 }
	 public Joueur getplayer(){
		 return player;
	 }
	 public Equipement geteq(){
		 return equipement;
	 }
	 public int gettabperso(int x,int y){
		 return tabperso[x][y];
	 }
	 public int gettabrocher(int x,int y){
		 return tabrocher[x][y];
	 }
	 public Rocher getrocher(int x){
		 return roch[x];
	 }
	 public int gettabforge(int x,int y){
		 return tabforge[x][y];
	 }
	 public Forge getforge(int x){
		 return forg[x];
	 }
	 public int gettabboss(int x,int y){
		 return tabboss[x][y];
	 }
	 public Boss getboss(int x){
		 return boss[x];
	 }
	 public Personne getperso(int x){
		 return perso[x];
	 }
	 public Map getMap(){
		 return map;
	 }
	 public GameContainer getcontainer(){
		 return container;
	 }

	@Override
	public void componentActivated(AbstractComponent arg0) {
		
		
	}
	 
	 
     
}
