delete from user;
INSERT INTO user VALUES (1, 'Bruce', 'Wayne', 'bbatman', 'gothamcity1'),
                        (2, 'Clark', 'Kent', 'supermn', 'metropolis1'),
                        (3, 'Diana', 'Prince', 'wnwoman', 'paradiseis1'),
                        (4, 'Barry', 'Allen', 'fflash', 'speedster1'),
                        (5, 'Hal', 'Jordan', 'glantern', 'lanterns1'),
                        (6, 'Arthur', 'Curry', 'aquamn', 'altantis1'),
                        (7, 'Carter', 'Hall', 'hawkmn', 'thanagar1');
delete from concept;
INSERT INTO concept VALUES (1, 1, 'Jedi', 'Abstracts', 9, 'An ancient religion whose followers defend the galaxy and are beleived to have legendary powers.'),
                           (2, 1, 'The Force', 'Abstracts', 9, 'The name for the energy that ties the universe together. Jedi and Sith can manipulate this energy.'),
                           (3, 1, 'Darth Vader', 'Characters', 1, 'An evil Sith Lord named Anakin Skywalker, underground leader of the Empire and father to Luke Skywalker and Leia Organa.'),
                           (4, 2, 'Han Solo', 'Characters', 1, 'A human male smuggler who goes on to become a leader of the Rebel Alliance against the empire.'),
                           (5, 2, 'Chewbacca', 'Creatures', 2, 'A Wookie companion and partner of Han Solo who also goes on to become a leader in the Rebel Alliance.'),
                           (6, 2, 'Millenium Falcon', 'Vehicles', 7, 'Han Solos unique and modified space cruiser and cargo ship. Known as the fastest ship in the galaxy.'),
                           (7, 3, 'R2D2', 'Mecha', 8, 'An astromech droid that contains a lot of knowledge valuable to the Rebel Alliance. Built by Anakin Skywalker.'),
                           (8, 3, 'C3P0', 'Mecha', 9, 'A protocol droid that is the companion to R2D2 and help the Rebel Alliance. Also built by anakin Skywalker.'),
                           (9, 4, 'Wookiee', 'Creatures', 2, 'Wookiees are a species of tall, hairy humanoids that are native to the planet Kashyyyk.'),
                           (10, 4, 'Bowcaster', 'Weapons', 4, 'A bowcaster, also known as a laser crossbow, was a handcrafted projectile weapon commonly used by Wookiees.'),
                           (11, 4, 'Kashyyyk', 'Environments', 3, 'Kashyyyk, is a tree-covered forest planet and the homeworld of the Wookiee species.'),
                           (12, 5, 'Tatooine', 'Environments', 3, 'Tatooine is a desert world in the Outer Rim that is inhabited by poor locals who mostly farmed moisture for a living.'),
                           (13, 5, 'Star Destroyer', 'Vehicles', 7, 'A medium-sized capital ship used by the Galactic Empire, as well as heavily armed warships in general.'),
                           (14, 6, 'Lightsaber', 'Weapons', 4, 'Also referred to as a laser sword, this was a weapon usually used by the Jedi, the Sith, and other Force-sensitives.'),
                           (15, 6, 'Scanner Pack', 'Accessories', 5, 'Scanner packs are larger portable scanners commonly used to detect technology and lifeforms.'),
                           (16, 7, 'Hyperdrive', 'Accessories', 5, 'A propulsion system that allowed a starship to reach lightspeed and travel in the alternate dimension of hyperspace.'),
                           (17, 7, 'Kyber Crystal', 'Resources', 6, 'These are rare Force-attuned crystals that grow throughout the galaxy. They concentrate energy in a unique manner through resonating with the Force, and as such are used in the creation of lightsaber and other laser bladed weapons.');
