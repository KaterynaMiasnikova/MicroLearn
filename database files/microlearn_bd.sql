use microlearn;
drop table learns_theme;
drop table learned_portion;
drop table liked_fact;
drop table feedback;
drop table portion;
drop table theme;
drop table area;
drop table fact;
drop table users;
create table users (
id_u bigint auto_increment, 
name_u varchar(255) not null, 
surname varchar(255) not null, 
email varchar(255) not null, 
password_u varchar(50) not null, 
primary key (id_u),
constraint unique_email UNIQUE (email));

create table area (
id_a bigint auto_increment, 
name_a text not null,
primary key (id_a));

create table fact (
id_f bigint auto_increment, 
fact text not null, 
link text, 
picture text, 
primary key (id_f));

create table theme (
id_t bigint auto_increment, 
name_t varchar(255) not null, 
id_a bigint not null, 
description_t text, 
picture text, 
primary key (id_t),
constraint `theme_area` foreign key (`id_a`) references `area` (`id_a`));

create table portion (
id_p bigint auto_increment, 
name_p varchar(255) not null, 
portion text, 
id_t bigint not null, 
primary key (id_p),
constraint `portion_theme` foreign key (`id_t`) references `theme` (`id_t`));

create table feedback (
id_fb bigint auto_increment, 
answer1 int, 
answer2 int, 
answer3 int, 
id_u bigint, 
id_p bigint, 
primary key (id_fb),
constraint `users_feedback` foreign key (`id_u`) references `users` (`id_u`),
constraint `feedback_to_portion` foreign key (`id_p`) references `portion` (`id_p`)
);

create table liked_fact (
id_u bigint,  
id_f bigint, 
primary key (id_u, id_f),
constraint `liked_user` foreign key (`id_u`) references `users` (`id_u`),
constraint `liked_fact` foreign key (`id_f`) references `fact` (`id_f`)
);

create table learned_portion (
id_u bigint,  
id_p bigint, 
primary key (id_u, id_p),
constraint `learned_user` foreign key (`id_u`) references `users` (`id_u`),
constraint `learned_portion` foreign key (`id_p`) references `portion` (`id_p`)
);

create table learns_theme (
id_u bigint,  
id_t bigint, 
primary key (id_u, id_t),
constraint `learns_user` foreign key (`id_u`) references `users` (`id_u`),
constraint `learns_theme` foreign key (`id_t`) references `theme` (`id_t`)
);

insert into users (id_u, name_u, surname, email, password_u) values
(1,"Kateryna","Miasnikova","miasnikova","193k"),
(2,"Darya","Melnyk","melkusha","2102193"),
(3,"Tom","Hiddleston","loki","tesseract"),
(4,"Percy","Jackson","seaweed","brain"),
(5,"Anabeth","Chase","wisegirl","cabin6");  

insert into fact (id_f, fact, link, picture) values
(1,"There is a man who claims to have traveled to an alternate dimension in which The Beatles never broke up and brought back a mix tape of The Beatles songs, no one in this dimension has ever heard.",
"http://instanerd.me/v/73/the-beatles","https://media.vov.vn/uploaded/haphuong/2014_01_14/beatles_autograph.jpg"),
(2,"Eating dark chocolate widens arteries and promotes healthy blood flow that can prevent the buildup of plaque that can block arteries.",
"http://instanerd.me/v/328/benefits-of-dark-chocolate","https://i0.wp.com/post.healthline.com/wp-content/uploads/2021/02/dark-chocolate-bar-1296x728-header.jpg?w=1155&h=1528"),
(3,"Pamukkale is mysterious place in Turkey also known as Cotton Castle. There are seventeen hot-water springs in the area that spill out water in temperatures ranging from 95 degrees to 212 degrees, which contains a high concentration of calcium bicarbonate. The water flows off a cliff, cools and hardens into calcium deposits that form terraces. These terraces are as white as cotton and bright enough to be easily seen from the town of Denizli.",
"http://instanerd.me/v/208/pamukkale-is-mysterious-place-in-turkey","https://sofiaadventures.com/wp-content/uploads/2020/02/shutterstock_1429356797.jpg"),
(4,"In order female pigeon's ovaries to function, she must look into another pigeon or at least her own reflection in the mirror.",
"http://instanerd.me/v/235/the-female-pigeon-cannot-lay-eggs-if-she-is-alone","https://cdn.download.ams.birds.cornell.edu/api/v1/asset/308067801/1800"),
(5,"In severe situations of dehydration when the electrolytes are thrown out of balance and can create serious problems, a drink of a pure and clean coconut water can increase the levels of electrolyte potassium and restore the hydration.",
"http://instanerd.me/v/221/the-truth-about-coconut-water","https://images.immediate.co.uk/production/volatile/sites/30/2017/08/coconut-water-bb9cfe8.jpg");

insert into area (id_a, name_a) values
(1,"Social movements"),
(2,"Art"),
(3,"Internet aesthetics"),
(4,"Culture"),
(5,"Geography");  

insert into theme (id_t, name_t, id_a, description_t, picture) values
(1,"Feminism",1,"feminism, the belief in social, economic, and political equality of the sexes. Although largely originating in the West, feminism is manifested worldwide and is represented by various institutions committed to activity on behalf of women’s rights and interests.",
"https://images.squarespace-cdn.com/content/v1/5475f6eae4b0821160f6ac3e/1646643731601-8YABYGYRW1KW2BRV2NKJ/feminismo+diversidad.jpg"),
(2,"Crochet",2,"Crochet is a process of creating textiles by using a crochet hook to interlock loops of yarn, thread, or strands of other materials. The name is derived from the French term crochet, meaning 'small hook'. Hooks can be made from a variety of materials, such as metal, wood, bamboo, or plastic. The key difference between crochet and knitting, beyond the implements used for their production, is that each stitch in crochet is completed before the next one is begun, while knitting keeps many stitches open at a time.",
"https://sarahmaker.com/wp-content/uploads/2021/07/how-to-double-crochet-24-768x1024.jpg"),
(3,"Knitting",2,"Knitting is a method by which yarn is manipulated to create a textile, or fabric. It is used to create many types of garments. Knitting may be done by hand or by machine. Knitting creates stitches: loops of yarn in a row, either flat or in the round (tubular). There are usually many active stitches on the knitting needle at one time. Knitted fabric consists of a number of consecutive rows of connected loops that intermesh with the next and previous rows. As each row is formed, each newly created loop is pulled through one or more loops from the prior row and placed on the gaining needle so that the loops from the prior row can be pulled off the other needle without unraveling.",
"https://nimble-needles.com/wp-content/uploads/2021/09/how-to-knit-for-beginners.jpg"),
(4,"Cottagecore",3,"Cottagecore is a fashion aesthetic popularised by teenagers and young adults celebrating an idealised rural life. Traditionally based on a rural English and European life. It was developed throughout the 2010s and was first named cottagecore on Tumblr in 2018. The aesthetic centres on traditional rural clothing, interior design, and crafts such as drawing, baking, and pottery, and is related to similar aesthetic movements such as grandmacore, farmcore, goblincore, and fairycore. Some sources describe cottagecore as a subculture of Millennials and Generation Z.",
"data:image/jpeg;base64,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"),
(5,"Generation Z",4,"Generation Z (or Gen Z for short), colloquially also known as zoomers, is the demographic cohort succeeding Millennials and preceding Generation Alpha. Researchers and popular media use the mid to late 1990s as starting birth years and the 2010s as ending birth years. Most members of Generation Z are children of Generation X.",
"https://www.ambista.com/media/view/65958/size/w1080"),
(6,"Mountains",5,"",""),
(7,"Rivers",5,"",""),
(8,"Dances",4,"",""),
(9,"International cuisine",4,"",""),
(10,"Musical instruments",4,"",""),
(11,"Public transport",5,"","");

insert into portion (id_p, name_p, portion, id_t) values
(1,"Interesting Facts About Crochet You May Not Know","Crochet saved lives
According to crochet.org, crochet was a virtual lifesaver during the potato famine in Ireland. Many Irish relied on earnings from the crochet pieces they created. There were even schools formed to teach crochet to the people there so they could save up the money necessary to emigrate to America.

The earliest crochet patterns were printed in 1824!

Many people crochet for a good cause
There's a non-profit company called Knots of Love, who has donated over 339, 399 hats to those who are going through chemo. They also donate blankets to provide warmth for babies born prematurely. 

There's such a thing as crochet boobs
Yep, crocheted boobs. There's been recent hype over Knitted Knockers, a charity that provides special handmade breast prosthesis for women who have undergone mastectomies or other procedures to the breast. Supposedly lactation consultants use them to help teach new mothers how to breastfeed. There's a free pattern for crochet boobs you can find here.

The largest ever crochet blanket measures about 120,000 square feet
The Guinness World Record for largest crochet blanket is held by Subashri Natarajan, of India. She had the help of over 1,000 people to combine hundreds of 40x40 inch sections to create the massive piece. After the record was confirmed, much of the piece was donated to charities.

Yarn bombing day this year is June 11
Yarn bombing (which is basically yarn graffiti) is a fun and expressive was for knitters and crocheters to display their work in public places.",2),
(2,"THINGS MOST PEOPLE HAVE NO IDEA ABOUT WHEN IT COMES TO KNITTING","KNITTING FACT #1
Knitting is centuries old – since knitting materials tend to degrade with time, it is hard to pinpoint when knitting appeared. According to historical sources, it seems to have been brought by the Crusaders from the Middle East. The term “knitting” is mentioned in the 14th century for the first time.

KNITTING FACT #2
A former type of knitting was done with just one needle. A cross over between knitting and crocheting was being practiced even by the Ancient Egyptians!

KNITTING FACT #3
In the 16th century France, knitting was an occupation for males only. Go figure!

KNITTING FACT #4
The first knitting machine was invented in 1589. The man who came with the idea was named William Lee and it was under the Queen Elizabeth I that this happened. From that point forward, knitting became a leisure activity mostly performed by hand inside the home.

KNITTING FACT #5
During World War I, women had the national duty to knit socks, scarves and caps for the soldiers fighting across the battlefields. While many sent knitted items to their family members stationed in cold areas, others knitted for the sake of every soldier in the land.

KNITTING FACT #6
Did you know that knitting can reduce heart rate, blood pressure and it relaxes, so that the body can fight illness better?

KNITTING FACT #7
In the beginning, cotton and silk were more popular than wool as knitting yarn.

KNITTING FACT #8
A book by Johann Siebmacher was published in 1611, as the first documentation of no fewer than 126 knitting patterns!

KNITTING FACT #9
You may think that knitting needles should only be made of metal or wood, but back in the days they were made of far more exotic materials, such as ivory, tortoise shell or bones.",3),
(3,"What Exactly Is Cottagecore","If you’ve started to see a steady trickle—or maybe even a deluge—of images of nostalgic countryside scenes and peasant dresses with eyelet lace popping up in your social media streams, you’re not alone: Cottagecore, a movement hearkening back to agricultural life, skills, and crafts, is on the rise. “As a concept, it embraces a simpler, sustainable existence that is more harmonious with nature. Aesthetically, it’s a nod to the traditional English countryside style, romantic and nostalgic,” says Davina Ogilvie, founder of Wovn Home, a start-up that makes custom (but affordable and accessible) window treatments.
Believe it or not, you may have even partaken in some cottagecore activities without even realizing it: dutifully maintaining a sourdough starter (even if the actual bread you made didn’t turn out so well), suddenly realizing that you need a Laura Ashley–esque floral print dress with ruffles (the ’90s really are back), or finding refuge in the great outdoors and its bountiful offerings (who says you have to WFH from an actual desk?).
And while the activities and aesthetics that cottagecore embraces are wide-ranging and complex, covering everything from fashion to gardening, cooking to frolicking, so too are its origins. It’s in part a reaction against capitalism and our increasing time spent in front of a screen, but also related to ongoing interests in wellness and sustainability, and more broadly the idea of social consciousness. Some saw cottagecore emerging as early as 2017, but most say that it really came into its own in 2019, thanks in part to its popularity on TikTok, notes Noemie Sérieux, founder of the Instagram account CottagecoreBlackFolk.
Cottagecore began to fill people’s social media feeds on Instagram, TikTok, Tumblr (yes, that’s still a big community!), and beyond; the New York Times even published a piece in March of this year about cottagecore, calling it “a budding aesthetic movement.” Enter the pandemic, and it went from “budding” to blooming to full-on booming. “With ample time on our hands when the pandemic hit and quarantine became commonplace across the globe, we turned to finding fulfillment and purpose outside of our monetary potential—and cottagecore was the perfect vehicle,” explains Noemie. And suddenly, with so much time at home, it seemed like everyone was baking focaccia laced with herbs and colorful vegetables, planning summer gardens in their backyard, and engaging in grandma-inspired craft projects like knitting and embroidery.",4),
(4,"History of Cottagecore","Precursors
Cottagecore is a continuation of ideas that have existed for millenia and uses visuals that are based in the aesthetic of the European countrysides. The evolution of these ideas into contemporary Cottagecore, an aesthetic borne out of the internet and among teenagers to young adults, is the primary history of this section, but also describes the history of Cottagecore's precursors as well.
One of the largest influences is the artistic movement of Romanticism, which emphasized a connection to nature, the past, and the senses, rather than logic.[1] It also encouraged a sense of national pride, which led to British landscape artists in particular to paint scenes of rural small towns, often with the same thatched cottages admired today. Similarly, this artistic movement was a reaction to the Industrial Revolution, much like how Cottagecore now is against the increasingly capitalistic and industrialized economy.
The next artistic movement that revived this love for British cottages is the Arts and Crafts movement, which focused on decorative arts such as furniture, ceramics, illustration, etc. Floral patterning was extremely popular, as well as a lighter and softer interpretation of what art is supposed to be.
Also around this time, Beatrix Potter released her Peter Rabbit children's books, which is one of the first introductions people had to the Victorian garden aesthetic, with the soft watercolors and sense of innocence. Other influential children's literature published in the 19th century include Heidi, The Secret Garden, and Anne of Green Gables. These books had a common appreciation for femininity and nature, and with lush descriptions of food and activities being prominenetly featured throughout. Despite their age, these works are incredibly popular with the children oftoday, and this nostalgia continues to inspire people who read these novels in their childhood.
An additional genre that 'created' Cottagecore was also fantasy, especially with J.R.R. Tolkien's Lord of the Rings series and various fairytales, especially that of the fae in Britain and Ireland. These books lend a sense of adventure and folkloric superstition to the aesthetic, and it is not uncommon for appreciators to do a few rituals typically associated with fairies for the sake of them.
Visually, much of Cottagecore takes inspiration from the 1970s, which had a fashion and home decor aesthetic known as Romantic Revival and Shabby Chic, led mostly by the companies Gunne Sax and Laura Ashley. Cottagecore fashion is largely a continuation of the designs that they used: prairie dresses in floral calico print, with heirloom sewing details, antique furniture, and soft pastels. The interior design details of Shabby Chic have similar grandmotherly connotations.
The Japanese alternative fashion Mori Kei also had an extremely large influence on the aesthetic, especially since the fashion was popular on tumblr in the early to mid-2010s. This was the de-facto feminine, nature-based, and cozy aesthetic. However, like many other trends, Mori Kei dwindled out. But as Cottagecore gained in popularity, there was a spike in Google trend searches for the fashion, showing a clear lineage in the fashion.[2]

Internet Popularization

In 2019 tumblr, the animated show Moomin Valley became a meme and frequent topic of conversation on the website. It popularized Cottagecore, as the characters lived in this sort of environment, with scenes of foraging, frolicking, and adventuring. Tumblr users wished for this sort of lifestyle, and the television show became a common gateway to the aesthetic. Studio Ghibli animated films have also been quite prevalent on the site, and users would have noted the commonalities between these two franchises and explored similar photographs and activities.
During this same time, there was the trend of 'yearning' on tumblr. Users would post about wishing for romantic partners and situations to happen, focusing on 'tenderness' such as holding hands and sharing fruit. This was especially popular among the queer community, which is constantly in the process of redefining and creating images of love outside of the heteronormative imagery and traditions of the past.
The 2020 coronavirus pandemic also led to the rise of Cottagecore as activities such as baking bread[4], playing Animal Crossing[5], gardening, sewing, and other handicrafts[6] rose in popularity. Coupled with a rise of the app TikTok, people were more exposed to crafting and these activities became trends.
Another quarantine trend in 2020 was Lirika Matoshi's 'Strawberry Dress,' a pink tulle gown with sequined strawberries and a milkmaid style. As Vogue describes it, the appeal of the dress is '...that sweet strawberry print is deeply nostalgic, hearkening back to a time long before COVID-19, to a childhood innocence that feels especially soothing right now.' Like Moomin Valley, the dress was incredibly meme-ified, with it appearing in non-Cottagecore contexts, such as in fan-art.[7] Its popularity led to people, especially on TikTok, to discover the aesthetic.
Throughout 2020, Cottagecore was made aware to various audiences as publications such as Vox and The New York Times reported on the trend. It later filtered down to various magazines and other interest sites, making the aesthetic's name fairly well-known among fashion, interior design, and crafting enthusiasts.
The aesthetic became even more well-known with the release of Taylor Swift's July 2020 album Folklore, as the singer's visual and musical styles would influence many of her fans' tastes.",4),
(5,"What Are the Core Characteristics of Generation Z?","Generation Z has emerged as a population increasingly worthy of attention, especially now as its older members enter young adulthood. Born after 1995, Generation Z ers made up one tenth of the 2020 electorate; and while they share a number of characteristics with Millenni-als, their formative years have been shaped by a drastically different world, resulting in key differences in attitudes, tendencies and outlook. Statistics compiled by the Pew Research Center paint a clear picture. Here’s what we know:

DIVERSITY IS THEIR NORM
One of the core characteristics of Generation Z is racial diversity. As America’s demographics continue to shift, Gen Z will be the last generation that is predominantly white. A slight majori-ty of Gen Z ers (52%) is white; 25% is Hispanic, 14% is Black and 4% is Asian.
For many Gen Z ers, the backdrop of their early years included the country’s first Black presi-dent and the legalization of gay marriage. They are more likely to have grown up amid diverse family structures — whether in a single parent household, a multi-racial household, or a household in which gender roles were blurred. As a result, they are less fazed than previ-ous generations by differences in race, sexual orientation or religion.

THEY ARE OUR FIRST “DIGITAL NATIVES”
Another characteristic of Generation Z is their native use of technology. Whereas Millennials were considered “digital pioneers,” who bore witness to the explosion of technology and social media, Gen Z was born into a world of peak technological innovation — where information was immediately accessible and social media increasingly ubiquitous.
These technological advancements have had both positive and negative effects on Gen Z. On the plus side: an abundance of information is at their fingertips, allowing Gen Z ers to broaden their knowledge and be proactive in their learning. On the other hand, too much screen time can compound feelings of isolation and lead to underdeveloped social skills. Addi-tionally, technology is changing the economy, leaving low-income Gen Z ers vulnerable as they enter the workforce.

THEY ARE PRAGMATIC AND FINANCIALLY-MINDED
Financial mindedness is another core characteristic of Generation Z. Many Gen Z ers grew up watching their parents take huge financial hits during the Great Recession. Having wit-nessed their parents’ struggles, this generation is driven by pragmatism and security.
While Millennials came of age during an economic boom, Gen Z ers were shaped by the eco-nomic pressures their families and communities faced, from the financial stress of the rental market to the added costs to kids and caregivers staying in touch with incarcerated parents. Thus, they value the stability that comes with conservative spending, stable jobs and smart investments.

MANY FACTORS CONTRIBUTE TO THEIR MENTAL HEALTH CHALLENGES
Mental health challenges are a sad characteristic of Generation Z, which has been referred to by some as the “loneliest generation,” as their endless hours spent online can foster feelings of isolation and depression. More time spent on smartphones or watching Netflix means less time spent cultivating meaningful relationships. Additionally, many young people fall prey to the “compare and despair” trap that social media presents.
Gen Z kids also find their mental health affected by the turbulent state of the world. As politi-cal activism among Gen Z has increased, many Gen Z ers have internalized the unrest sur-rounding issues like gun control, police brutality and climate change — leading to increased levels of stress.

THEY ARE SHREWD CONSUMERS
As consumers, Gen Z’s behavior reflects their values — and the influence of an increasingly digital world. Gen Z kids can rely on their tech savvy and extensive social networks to make informed purchasing decisions. Their pragmatism leads them to explore and evaluate a range of options before settling on a product. In addition, they are more likely to be swayed by the recommendations of real-life users than by celebrity endorsements.
In much the same way that Gen Z ers use social media as a means to curate their own per-sonal brand, they also look at their purchasing decisions as an expression of their values and identity. As an example, they are drawn to sustainable products and brands — and are often willing to pay more for them. They value personalized products, and they are drawn to brands who share their point of view on political issues.

THEY ARE POLITICALLY PROGRESSIVE — EVEN THOSE ON THE RIGHT
Most generations tend to be more left-leaning than the previous generation, and Gen Z is no exception. While Gen Z ers look a lot like Millennials on many key issues, they are the most politically progressive generation yet. They are the least likely generation to approve of Presi-dent Trump’s leadership, and they are the most likely generation to see the advancement of LGBTQ rights as a positive development. Even among Republicans, Gen Zers take a more progressive stance on social issues: they agree that Blacks are treated more unfairly in this country, they believe the government should play a greater role in solving problems and they are more likely to attribute climate change to human activity, as opposed to natural patterns.

CONTINUE LEARNING ABOUT GENERATION Z
Gen Z still has a lot of growing up to do. But as they continue to come of age, early signs indicate that they will grow into engaged, conscientious stewards of our world — by being socially-minded, independent thinkers, who recognize their responsibility in shaping a more equitable future for all.",5),
(6,"Carpathian Mountains","The Carpathian Mountains or Carpathians are a range of mountains forming an arc across Central Europe. Roughly 1,500 km long, it is the third-longest European mountain range after the Urals at 2,500 km and the Scandinavian Mountains at 1,700 km. The range stretches from the far eastern Czech Republic (3%) and Austria (1%) in the northwest through Slovakia (21%), Poland (10%), Ukraine (10%), Romania (50%) to Serbia (5%) in the south. The highest range within the Carpathians is known as the Tatra mountains in Slovakia and Poland, where the highest peaks exceed 2,600 m. The second-highest range is the Southern Carpathians in Romania, where the highest peaks range between 2,500 m and 2,550 m.",6),
(7,"Danube","The Danube is the second-longest river in Europe. It flows through much of Central and Southeastern Europe, from the Black Forest into the Black Sea. A large and historically important river, it was once a frontier of the Roman Empire and today connects ten European countries, running through their territories or being a border. Originating in Germany, the Danube flows southeast for 2,850 km, passing through or bordering Austria, Slovakia, Hungary, Croatia, Serbia, Romania, Bulgaria, Moldova, and Ukraine. Among the many cities on the river are 4 capitals: Vienna, Budapest, Belgrade and Bratislava. Its drainage basin amounts to 817 000 km² and extends into nine more countries.",7),
(8,"Hopak","Hopak is a Ukrainian folk dance originating as a male dance among the Zaporozhian Cossacks, but later danced by couples, male soloists, and mixed groups of dancers. It is performed most often as a solitary concert dance by amateur and professional Ukrainian dance ensembles, as well as other performers of folk dances. It has also been incorporated into larger artistic opuses such as operas, ballets and theatre.\nThe hopak is often popularly referred to as the \"National Dance of Ukraine\" and has become very popular in Poland. There are similar folkloric dance tunes known as Sirmpa in Leros, Greece.",8),
(9,"Palyanytsya","Palyanytsya is a type of Ukrainian hearth-baked bread, made mostly of wheat flour in a home oven. The yeast hearth bread has a semi-circular cut across the top third of the loaf.\nIn Christianity, palyanytsya, like bread in general, symbolizes happiness and can represent well-being, the body of God, affection, hospitality and security. Palyanytsya can also be interpreted as a symbol of the sun.\nAccording to popular belief, you should not eat a piece of palyanytsya after another person, as doing so will take away their happiness. It is also unlucky to leave a piece uneaten; and eating bread behind another person's back will \"eat\" their strength.",9),
(10,"Trembita","The trembita is an alpine horn made of wood. It is common among Ukrainian highlanders Hutsuls who live in western Ukraine, eastern Poland, Slovakia, and northern Romania.\nA trembita was used primarily by mountain dwellers known as Hutsuls and Gorals in the Carpathians, it was used as a signaling device to announce deaths, funerals, weddings.\nThe tube is made from a long straight piece of pine or spruce (preferably one that has been struck by lightning) which is split in two in order to carve out the core. The halves are once again joined together and then wrapped in birch bark or osier rings. It is also used by shepherds for signaling and communication in the forested mountains and for guiding sheep and dogs. The trembita has a timbre that is much brighter than that of the alpenhorn due to its narrow bore and very minor flare.",10),
(11,"Kobza","The kobza, also called bandurka, is a Ukrainian folk music instrument of the lute family, a relative of the Central European mandora. The term kobza however, has also been applied to a number of other Eastern European instruments distinct from the Ukrainian kobza.\nThe term kobza is of Turkic origin and is related to the terms kobyz and komuz, thought to have been introduced into the Ukrainian language in the 13th century with the migration of a sizable group of Turkic people from Abkhazia settling in the Poltava region. It was usually played by a bard or minstrel known as a kobzar (occasionally in earlier times a kobeznik), who accompanies his recitation of epic poetry called duma in Ukrainian.",10),
(12,"Arsenalna (Kyiv Metro)","Arsenalna is a station on Kyiv Metro’s Sviatoshynsko-Brovarska Line. The station was opened along with the first stage and is currently the deepest station in the world at 105.5 metres. This is attributed to Kyiv’s geography, where the high bank of the Dnipro River rises above the rest of the city. Also unusual is the station’s design, which lacks a central concourse and is thus similar in layout to stations on the London Underground.\nSince 1986, the station has the status of \"architectural monument of local significance\".",11);


insert into feedback (id_fb, answer1, answer2, answer3, id_u, id_p) values
(1,1,1,1,1,1),
(2,0,0,0,2,5),
(3,1,1,0,5,3),
(4,1,0,1,5,4),
(5,0,1,1,3,2);


insert into liked_fact (id_u, id_f) values
(1,2),
(1,4),
(3,1),
(5,2),
(2,2);

insert into learned_portion (id_u, id_p) values
(1,1),
(2,5),
(5,4),
(5,3),
(3,2);

insert into learns_theme (id_u, id_t) values
(1,1),
(1,10),
(2,5),
(5,4),
(5,3),
(3,2);

