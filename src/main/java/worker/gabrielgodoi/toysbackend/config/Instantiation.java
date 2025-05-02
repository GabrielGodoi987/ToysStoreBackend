package worker.gabrielgodoi.toysbackend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import worker.gabrielgodoi.toysbackend.entities.Category;
import worker.gabrielgodoi.toysbackend.entities.Toys;
import worker.gabrielgodoi.toysbackend.repository.CategoryRepository;
import worker.gabrielgodoi.toysbackend.repository.PhotoRepository;
import worker.gabrielgodoi.toysbackend.repository.ToysRepository;

import java.util.ArrayList;
import java.util.Arrays;

@RequiredArgsConstructor
@Configuration
@Profile("test")
public class Instantiation implements CommandLineRunner {
    private final ToysRepository toysRepository;
    private final CategoryRepository categoryRepository;
    private final PhotoRepository photoRepository;

    @Override
    public void run(String... args) throws Exception {
        String img = "https://toymania.vtexassets.com/arquivos/ids/965823-1200-auto?v=637871976187200000&width=1200&height=auto&aspect=true";
        Category cat1 = new Category(null, img, "Educativos");
        Category cat2 = new Category(null, img, "Eletrônicos");
        Category cat3 = new Category(null, img, "Esportivos");
        Category cat4 = new Category(null, img, "Pelúcias");

        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));

        Toys toy1 = new Toys(null, "Blocos de Montar", 59.99, "Blocos coloridos para montar formas.", "Diversão e aprendizado!", Arrays.asList("- Peças grandes e seguras", "- Estimula a criatividade"), cat1, new ArrayList<>());
        Toys toy2 = new Toys(null, "Quebra-Cabeça 3D", 69.99, "Desafio em 3D para estimular o raciocínio.", "Monte e admire!", Arrays.asList("- Peças de encaixe preciso", "- Visualização espacial"), cat1, new ArrayList<>());
        Toys toy3 = new Toys(null, "Jogo da Memória", 39.99, "Cartas divertidas para exercitar a memória.", "Teste sua concentração!", Arrays.asList("- Ilustrações coloridas", "- Várias dificuldades"), cat1, new ArrayList<>());
        Toys toy4 = new Toys(null, "Ábaco Infantil", 49.99, "Aprenda matemática brincando.", "Contar nunca foi tão fácil!", Arrays.asList("- Bolas deslizantes", "- Base resistente"), cat1, new ArrayList<>());
        Toys toy5 = new Toys(null, "Livro Interativo", 44.99, "Livro com som e texturas educativas.", "Descubra um mundo de sensações!", Arrays.asList("- Sons de animais", "- Texturas variadas"), cat1, new ArrayList<>());

        Toys toy6 = new Toys(null, "Carrinho Controle Remoto", 99.99, "Velocidade e controle para crianças.", "Acelere a diversão!", Arrays.asList("- Fácil de controlar", "- Design moderno"), cat2, new ArrayList<>());
        Toys toy7 = new Toys(null, "Drone Mini", 149.99, "Drone com câmera para iniciantes.", "Explore o céu!", Arrays.asList("- Câmera integrada", "- Controle intuitivo"), cat2, new ArrayList<>());
        Toys toy8 = new Toys(null, "Robô Inteligente", 199.99, "Robô que fala e interage com crianças.", "Seu novo amigo interativo!", Arrays.asList("- Reconhecimento de voz", "- Funções programáveis"), cat2, new ArrayList<>());
        Toys toy9 = new Toys(null, "Tablet Infantil", 249.99, "Tablet com jogos educativos.", "Aprender e brincar em um só lugar!", Arrays.asList("- Tela sensível ao toque", "- Conteúdo educativo"), cat2, new ArrayList<>());
        Toys toy10 = new Toys(null, "Game Portátil", 129.99, "Videogame de bolso com jogos clássicos.", "Leve a diversão para onde for!", Arrays.asList("- Vários jogos inclusos", "- Tela colorida"), cat2, new ArrayList<>());

        Toys toy11 = new Toys(null, "Bola de Futebol", 34.99, "Bola resistente para crianças.", "Faça um gol de alegria!", Arrays.asList("- Material durável", "- Tamanho infantil"), cat3, new ArrayList<>());
        Toys toy12 = new Toys(null, "Patins Iniciante", 89.99, "Primeiros passos com segurança e diversão.", "Deslize na aventura!", Arrays.asList("- Rodas estáveis", "- Equipamento de segurança"), cat3, new ArrayList<>());
        Toys toy13 = new Toys(null, "Corda de Pular", 19.99, "Ideal para atividades físicas divertidas.", "Pule e se divirta!", Arrays.asList("- Leve e resistente", "- Alças confortáveis"), cat3, new ArrayList<>());
        Toys toy14 = new Toys(null, "Skate Infantil", 109.99, "Skate para pequenos aventureiros.", "Manobras radicais com segurança!", Arrays.asList("- Shape resistente", "- Rodas macias"), cat3, new ArrayList<>());
        Toys toy15 = new Toys(null, "Raquete de Frescobol", 39.99, "Diversão ao ar livre com amigos.", "Um jogo para toda a família!", Arrays.asList("- Leves e fáceis de manusear", "- Cabo ergonômico"), cat3, new ArrayList<>());

        Toys toy16 = new Toys(null, "Urso de Pelúcia", 54.99, "Clássico urso fofo e macio.", "Um amigo para todas as horas!", Arrays.asList("- Pelúcia antialérgica", "- Olhos bordados"), cat4, new ArrayList<>());
        Toys toy17 = new Toys(null, "Coelho Fofo", 49.99, "Pelúcia de coelho para abraçar.", "Um abraço macio e carinhoso!", Arrays.asList("- Pelúcia suave", "- Detalhes delicados"), cat4, new ArrayList<>());
        Toys toy18 = new Toys(null, "Dinossauro de Pelúcia", 59.99, "Dino divertido e aconchegante.", "Aventura jurássica no seu quarto!", Arrays.asList("- Pelúcia texturizada", "- Cores vibrantes"), cat4, new ArrayList<>());
        Toys toy19 = new Toys(null, "Almofada Divertida", 29.99, "Almofada com carinhas engraçadas.", "Deixe seu cantinho mais alegre!", Arrays.asList("- Tecido macio", "- Estampas divertidas"), cat4, new ArrayList<>());
        Toys toy20 = new Toys(null, "Gatinho Sonoro", 64.99, "Pelúcia com sons suaves e relaxantes.", "Miau! Uma melodia de carinho!", Arrays.asList("- Sons de ronronar", "- Olhos expressivos"), cat4, new ArrayList<>());

        this.toysRepository.saveAll(Arrays.asList(
                toy1,
                toy2,
                toy3,
                toy4,
                toy5,
                toy6,
                toy7,
                toy8,
                toy9,
                toy10,
                toy11,
                toy12,
                toy13,
                toy14,
                toy15,
                toy16,
                toy17,
                toy18,
                toy19,
                toy20
        ));
    }
}
