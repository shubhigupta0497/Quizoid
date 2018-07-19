package com.example.shubhigupta.quizoidnew;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class GameStartActivity extends AppCompatActivity {

    RadioGroup rg;
    TextView tv;
    boolean flag = true;
    TextView howToplay, gameStart, highscore;
    private Cursor p;
    String n;
    private SQLiteDatabase db;
//    String q[]={
//            "How many yards are there between wickets in a game of cricket",
//            "Which is the largest planet in the solar system?",
//            "Which of the following is a palindrome?",
//            "The word ISPISISPSMI is an anagram of which of the following?",
//            "If David travels one mile north, two miles west, one mile north, one mile east, three miles south, one mile east,how far will he be from his starting point?",
//            "Which of the following words is most associated with the word INTERMITTENT?",
//            "What month was last month if February is in three months?",
//            "If the word EWE is written above the word ZOO and the word TOE is written above the word EWE, would the number TWO appear diagonally?",
//            "Mia and Tilly have the same amount of sweets each. How many sweets should Mia give Tilly so that she has four sweets more?",
//            "Which of the following is least like the others?",
//            "Including the white ball, how many color varieties are used in a game of snooker?",
//            "Which body part can be placed before the following words? drum ache ring",
//            "Which continent has no active volcanoes?",
//            "In the fairytale Cinderella, what did Cinderella leave behind as she was leaving the ball?",
//            "What year did the American Civil War start?",
//            "Which country will host the 2016 Olympics?",
//            "Which season would the fall be known as in Great Britain?",
//            "Which is not among the three primary colors?",
//            "What is an expression of language meaning the opposite?","What is the primary religion in Thailand?",
//            "Which is the only body organ able to regenerate itself?","Complete the saying: A picture is worth...?",
//            "Dos is Spanish for which number?","How many hours are equal to 600 minutes?",
//            "Can you unscramble this word to find the name of a country: SUSAIR?",
//            "What is the meaning of the Latin phrase ‘bona fide’?","What do the fifty stars on the US flag represent?",
//            "Which country is first to appear in the English dictionary?","What is the last letter of the Greek alphabet?",
//            "What name is given to a triangle with one angle greater than 90 degrees?",
//            "What is the name of Scooby Doo`s psychedelic van?","What is the largest island in the Caribbean?",
//            "Which TV series features a chemistry teacher called Walter White?",
//            "Which F.R.I.E.N.D.S. character makes jokes when he is uncomfortable?",
//            "If you were born December 4th, which star sign would you belong to?",
//            "In the film Shrek, what is the name of Shrek`s wife?","What was the name of the boy in the Jungle Book?",
//            "What is the name of the actor who played the role of Harry Potter in the film series?",
//            "Which Bond movie did Daniel Craig first star in?","Who played Jack in the film The Titanic?",
//            "From which movie did this quote come from: A lie keeps growing and growing until it is as plain as the nose on your face?",
//            "How many square meters are there in a hectare?","How many rings does Saturn have around it?",
//            "Which of the five senses develops first?","How many carats are there in pure gold?",
//            "Who scored the winning penalty in the 2006 world cup final?","How many red balls are used in a game of snooker?",
//            "Who has won the most FIFA Ballons d Or?","In which sport is the Davis cup awarded?",
//            "At what time did Andres Iniesta score the winning goal to help Spain win their first World Cup ever?"
//
//    };
//    String a[]={"20","Pluto","yatch","Plant","Zero","Continuous","October","WWE","4","Length","6","Ear","Asia","Earring","1857","Argentina","Autumn","Red"
//            ,"Similie","Hinduism","Tooth","many words","22","20","Uruguay","in good faith","Presidents","Argentina","Omega","Obtuse","The Mystery Traveller",
//            "Cuba","Prison Break","Ross","Gemini","Alice","Timon","Daniel Radcliffe","Spectre","Christan Bale","Toy Story","10000","4","Touch","22",
//            "Andrea Pirlo","12","Cristiano Ronaldo","Football","117"};
//    String b[]={"18","Jupiter","racecar","Sporting Event","Two","Irregular","November","TEZ","1","Millimeter","7","Stomach","Australia","Glass Slipper",
//            "1872","England","Spring","Green","Irony","Jainism","Ear","1000 words","12","10","Russia","for this","States","Algeria","Alpha","Isoceles","The Van",
//            "Antigua","F.R.I.E.N.D.S.","Chandler Bing","Aries","Rapunzel","Mowgli","Justin Timberlake","Casino Royale","Mathew McCaughney","Pinocchio",
//            "100","3","Smell","24","Marco Matterazi","15","Ronaldinho","Cricket","113"};
//    String c[]={"22","Saturn","train","Sea Creature","One","Repetitive","January","OWO","3","Yard","8","Head","Europe","Ring","1867","Brazil","Summer",
//            "Blue","Metaphor","Buddhism","Stomach","10 words","2","60","USSR","word for word","50 top cities","Afghanistan","Delta","Acute","The Mystery Van","Barbados",
//            "Breaking Bad","Joey","Leo","Fiona","Leo","Rupert Grint","Thunderball","Russel Crowe","Finding Nemo","1","5","Taste","20","Fabio Grosso",
//            "9","Lionel Messi","Hockey","93"};
//    String d[]={"32","Mercury","car","River","Three","Consistent","September","TWO","2","Meter","4","Foot","Africa","Purse","1861","Russia","Winter",
//            "Yellow","Aside","Christanity","Liver","100 words","7","600","USA","after death","50 lakes","Australia","Gamma","Scalene","The Mystery Machine",
//            "Galle","Game Of Thrones","Rachel","Saggitarius","Cindrella","Pumba","Kevin McCauley","Skyfall","Leonardo DiCaprio","Ice Age","100","7","Sight",
//            "18","Alesandre Del Piero","1","Ronaldo","Tennis","121"};
//    int ans[]={2,1,1,3,2,1,0,3,3,0,2,0,1,1,3,2,0,1,1,2,3,1,2,1,1,0,1,2,0,0,3,0,2,1,3,2,1,0,1,3,1,0,3,1,1,2,1,2,3,0};
//String q[]={
//        // INTERNATIONAL BRANDS
//        "Which parent company owns brands such as Orville Redenbacher popcorn, Swiss Miss cocoa and Peter Pan peanut butter?",
//        "Despite its Danish sounding name, the ice cream Haagen Dasz is made in which country?",
//        "When was the first Apple logo introduced?",
//        "How much did the logo design for the London Olympic games cost?",
//        "What is the Twitter bird's real name?",
//        "Which famous car maker said that people could have any color of the Model T so long as it was black?",
//        "What color is the square on the Post-It logo?",
//        "What credit card says: \"everywhere you want to be\"?",
//        "Which of these is NOT a tagline that has been used by Coca-Cola over the last 100 years?",
//        "What cosmetic company says: \"Because You're Worth It\"?",
//        "\"Gimme a Break\" can be associated with what candy bar?",
//        "What car company uses a family coat of arms as their logo?",
//        "What type of candy \"Makes Your Mouth Happy\"?",
//        "The Olympic Committee sued which company over their logo?",
//        "Where can you \"Expect More. Pay Less. \"?",
//        "What country is responsible for the production of Maserati brand?",
//        "Which chocolatier makes two eggs: the \"Surprise\" which contains a toy and the \"Joy\" with white and milk chocolate?",
//        "\"Jerry's Guide to the World Wide Web\" was once the name of what well known company?",
//        "PayPal is a subsidiary of which company?",
//        "Which French-based aerospace company produces the A380, the world's largest passenger airliner?",
//        "Which of these is NOT a well-known beer brewed in Belgium?",
//        "Where in America did Ford first start producing cars?",
//        "Richard Branson founded which business empire?",
//        //INDIAN BRANDS
//        " Soap brand \"Pears\" is product of ?"," Kissan brand is associated with which type of product?",
//        " Tiger brand biscuits are manufactured by ?","  Which of the following product(s) are manufactured by Parle ?",
//        " Which of the following is a Mango flavored soft drink ?","  Ujala is a _______ brand ?",
//        "Ariel detergent brand is owned by ?","  Savings account for Kids My Junior Account is offered by which of the following bank ?",
//        " \"No more tears\" is a tagline of which of the following  ?","Hair Care product Vatika brand owned by ?",
//        "Therapeutic brand \"Vicks\" associated with","Brand name Meswak is used to market which product ?",
//        "KrackJack biscuits are manufactured by?","with brand name Wella which product is manufactured ?",
//        "Hotel Chain Ginger is owned by which group ?","Duracell Batteries are manufactured by by?",
//        "Digital media product brand Zune is associated with which company ?",
//        "First indian male actor to model for Lux soap ?","B Natural fruit Juices are manufactured by?",
//        //BUSINESS IN INDIA
//        "State bank of India previously known as ?",
//        "Which soft drink brand was endorsed by Michael Jackson ?",
//        "Who is the first cricketer to endorse Hublot watches ?",
//        "Full form of IT company HCL ?",
//        "Canara bank head quarters is located in which city ?",
//        "Who is chairman of Tata group ?",
//        "Full form of ACC cement company ?",
//        "Bank of India Headquarters is located in which Indian city ?",
//        "In which year NSE(National Stock exchange) established ?",
//        "Which Indian Private sector bank first issued Contact less debt and Credit cards ?",
//        "MTS is largest mobile operator in which country ?",
//        "Coca-Cola head quarters is located at which city ?",
//        "Which e-Commerce company acquired Fashion brand and online store Myntra ?",
//        "\"The name you can bank upon\" is the tagline of which Indian Public sector bank tagline ?",
//        "Full form of TCS is ?",
//        "What products Pepperfry.com sells online ?",
//        "Unique in it’s diversity is Which country tourism tagline ?",
//        "What is the name of Hong Kong Stock Market Index ?",
//        "HSBC is a \"Banking Corporation.\" What does the HS stand for?",
//        "In 2000, Olay dropped what two words from its brand name?",
//        "What is the full form of IBM ?",
//        "Search Engine Bing is owned by ?",
//        "In which year Yes bank was founded ?",
//        "Indian Conglomerate ITC head quarters is located in which Indian city ?",
//        //ECONOMICS
//        "Who is the father of Economics ?",
//        "Indian Economy is :",
//        "\"An Enquiry into the Nature and Causes of Wealth of Nations\" is the book of economist-",
//        "Who has given scarcity definition of economics ?",
//        "Which theory is generally included under micro economics ?",
//        "Whose opinions have revolutionised the scope of macro economics ?",
//        "Passive factor of production is ",
//        "Under law of demand ",
//        "For inferior commodities, income effect is",
//        "When total utility becomes maximum, then marginal utility will be",
//        "Utility means ",
//        "Marginal utility is equal to average utility at that time when average utility is",
//        "At point of satiety, marginal utility is",
//        "Which of the following is the second law of Gossen?",
//        "Total utility of a commodity is measured by which price of that commodity ?",
//        "According to Marshall, the basis of consumer surplus is",
//        "In investment management, what does the acronym ETF stand for?",
//        "In finance, what does M&A commonly stand for?",
//        "Who is the chairman of Planning Commission of India?",
//        "According to Modern Theory of Rent, rent accrues to ",
//        //CURRENCY
//        "What is the national currency of Afghanistan?", "What is the national currency of Albania?",
//        " What is the national currency of Algeria?","What is the national currency of Andorra?",
//        " What is the national currency of Angola?"," What is the national currency of Antigua and Barbuda?",
//        " What is the national currency of Argentina?"," What is the national currency of Armenia?",
//        " What is the national currency of Australia?"," What is the national currency of Austria?",
//        " What is the national currency of Azerbaijan?"," What is the national currency of The Bahamas?",
//        " What is the national currency of Bahrain?"," What is the national currency of Bangladesh?",
//        " What is the national currency of Barbados?"," What is the national currency of Vatican City?",
//        " What is the national currency of Yemen?"," What is the national currency of Morocco?",
//        " What is the national currency of Nepal?"," What is the national currency of Netherlands?",
//        " What is the national currency of Germany?",
//        //WORLD CAPITALS
//        "Cairo is the capital of which country?","Zagreb is the capital of which country?","Tbilisi is the capital of which country?","Santiago is the capital of which country?","Tehran is the capital of which country?","Buenos Aires is the capital of which country?","New Delhi is the capital of which country?","Pyongyang is the capital of which country?","Kabul is the capital of which country?",
//        "Reykjavik is the capital of which country?","Canberra is the capital of which country?","Port-au-Prince is the capital of which country?","Copenhagen is the capital of which country?","Helsinki is the capital of which country?","Tallinn is the capital of which country?",
//        "Kathmandu is the capital of which country?","Beirut is the capital of which country?","Ankara is the capital of which country?","Lima is the capital of which country?","Mogadishu is the capital of which country?","Bucharest is the capital of which country?",
//        "Warsow is the capital of which country?","Colombo is the capital of which country?",
//        //WORLD MOUNTAINS
//        "Mauna Kea is in which country/countries?","Ben Nevis is in which country/countries?","Mont Blanc is in which country/countries?","Vinson Massif is on which continent?","Aconcagua is in which country/countries?","Kilimanjaro is a mountain in which country/countries?",
//        "K2 is a mighty mountain in which country/countries?","Mount Everest is in which country/countries?","The mountain Annapurna is in which country/countries?","Mount McKinley is in which country/countries?","Table Mountain is in which country/countries?","Kailas is on which continent?",
//        "Bishorn is in which country/countries?","Mount Logan - Yukon is in which country/countries?","Shishapangma is in which country/countries?",
//        //WORLDS LAKES
//        "The Caspian Sea is NOT neighboured by which of the countries?","Michigan-Huron lake is between these countries?","Lake Victoria is NOT neighboured by this country?","Lake Baikal is the deepest lake in the world. In which country is it?",
//        "The Great Bear Lake is in which country?","The Great Slave Lake is in which country?","Ladoga is the largest lake in Europe. In which country is this?","Titicaca is one of the highest lakes in the world. Which country does neighbour it?","In which country is Vanern?",
//        "Winnipegosis is a lake in which country?","Great Salt Lake is in which country?","Qinghai Lake is the largest lake in East Asia. In which country is it?",
//        "Saimaa is a large lake with numerous basins and 14,000 islands. Where is this?","Lake of the Woods is neighboured by these countries.","Khanka is a lake on which continent?",
//        //ARITHMETIC APTITUDE
//        "A person crosses a 600 m long street in 5 minutes. What is his speed in km per hour?","An aeroplane covers a certain distance at a speed of 240 kmph in 5 hours. To cover the same distance in 1 2/3 hours, it must travel at a speed of:",
//        "If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more. The actual distance travelled by him is: ","A train can travel 50% faster than a car. Both start from point A at the same time and reach point B 75 kms away from A at the same time. On the way, however, the train lost about 12.5 minutes while stopping at the stations. The speed of the car is:",
//        "Excluding stoppages, the speed of a bus is 54 kmph and including stoppages, it is 45 kmph. For how many minutes does the bus stop per hour?",
//        "In a flight of 600 km, an aircraft was slowed down due to bad weather. Its average speed for the trip was reduced by 200 km/hr and the time of flight increased by 30 minutes. The duration of the flight is: ",
//        "A man complete a journey in 10 hours. He travels first half of the journey at the rate of 21 km/hr and second half at the rate of 24 km/hr. Find the total journey in km.",
//        "The ratio between the speeds of two trains is 7 : 8. If the second train runs 400 kms in 4 hours, then the speed of the first train is: ",
//        "A man on tour travels first 160 km at 64 km/hr and the next 160 km at 80 km/hr. The average speed for the first 320 km of the tour is:",
//        "A car travelling with 5/7 of its actual speed covers 42 km in 1 hr 40 min 48 sec. Find the actual speed of the car.",
//        "In covering a distance of 30 km, Celine takes 2 hours more than Sam. If Celine doubles his speed, then he would take 1 hour less than Sam. Celine\'s speed is: ",
//        "Robert is travelling on his cycle and has calculated to reach point A at 2 P.M. if he travels at 10 kmph, he will reach there at 12 noon if he travels at 15 kmph. At what speed must he travel to reach A at 1 P.M.? ",
//        "It takes eight hours for a 600 km journey, if 120 km is done by train and the rest by car. It takes 20 minutes more, if 200 km is done by train and the rest by car. The ratio of the speed of the train to that of the cars is: ",
//        "A farmer travelled a distance of 61 km in 9 hours. He travelled partly on foot @ 4 km/hr and partly on bicycle @ 9 km/hr. The distance travelled on foot is: ",
//        "A and B together have Sterling 1210. If 4/15 of A\'s amount is equal to 2/5 of B\'s amount, how much amount does B have? ",
//        "Two numbers are respectively 20% and 50% more than a third number. The ratio of the two numbers is: ","A sum of money is to be distributed among A, B, C, D in the proportion of 5 : 2 : 4 : 3. If C gets Euro 1000 more than D, what is B\'s share?",
//        "Seats for Mathematics, Physics and Biology in a school are in the ratio 5 : 7 : 8. There is a proposal to increase these seats by 40%, 50% and 75% respectively. What will be the ratio of increased seats? ","In a mixture 60 litres, the ratio of milk and water 2 : 1. If the this ratio is to be 1 : 2, then the quanity of water to be further added is: ",
//        "The ratio of the number of boys and girls in a college is 7 : 8. If the percentage increase in the number of boys and girls be 20% and 10% respectively, what will be the new ratio? ","If 0.75 : x :: 5 : 8, then x is equal to:",
//        //PERCENTAGE
//        "Two students appeared at an examination. One of them secured 9 marks more than the other and his marks was 56% of the sum of their marks. The marks obtained by them are: ","A fruit seller had some apples. He sells 40% apples and still has 420 apples. Originally, he had:","What percentage of numbers from 1 to 70 have 1 or 9 in the unit's digit?","In a certain school, 20% of students are below 8 years of age. The number of students above 8 years of age is 2/3 of the number of students of 8 years of age which is 48. What is the total number of students in the school?","A student multiplied a number by 3/5 instead of 5/3. What is the percentage error in the calculation?","In an election between two candidates, one got 55% of the total valid votes, 20% of the votes were invalid. If the total number of votes was 7500, the number of valid votes that the other candidate got, was: ","Three candidates contested an election and received 1136, 7636 and 11628 votes respectively. What percentage of the total votes did the winning candidate get? ","Helen went to the stationers and bought things worth Euro 25, out of which 30 paise went on sales tax on taxable purchases. If the tax rate was 6%, then what was the cost of the tax free items?","The population of a town increased from 1,75,000 to 2,62,500 in a decade. The average percent increase of population per year is: ",
//        //SERIES
//        "Look at this series: 2, 1, (1/2), (1/4), ... What number should come next?","Look at this series: 7, 10, 8, 11, 9, 12, ... What number should come next?","Look at this series: 36, 34, 30, 28, 24, ... What number should come next?","Look at this series: 22, 21, 23, 22, 24, 23, ... What number should come next?","Look at this series: 53, 53, 40, 40, 27, 27, ... What number should come next?","Look at this series: 21, 9, 21, 11, 21, 13, 21, ... What number should come next?","Look at this series: 58, 52, 46, 40, 34, ... What number should come next?","Look at this series: 3, 4, 7, 8, 11, 12, ... What number should come next?","Look at this series: 8, 22, 8, 28, 8, ... What number should come next?","Look at this series: 31, 29, 24, 22, 17, ... What number should come next?","Look at this series: 1.5, 2.3, 3.1, 3.9, ... What number should come next?","Look at this series: 14, 28, 20, 40, 32, 64, ... What number should come next?","Look at this series: 2, 4, 6, 8, 10, ... What number should come next?","Look at this series: 201, 202, 204, 207, ... What number should come next?","Look at this series: 544, 509, 474, 439, ... What number should come next?","Look at this series: 80, 10, 70, 15, 60, ... What number should come next?","Look at this series: 2, 6, 18, 54, ... What number should come next?","Look at this series: 1000, 200, 40, ... What number should come next?",
//        //SYNONYMS
//        "What is the synonym for ERRORNEOUS","What is the synonym for SEIZE","What is the synonym for FABLE","What is the synonym for DASH","What is the synonym for PREDICAMENT","What is the synonym for ALLOTMENT","What is the synonym for NEAT","What is the synonym for MOODY","What is the synonym for OGLE","What is the synonym for INDOLENT","What is the synonym for ENGAGING","What is the synonym for NOTION","What is the synonym for SHROUD","What is the synonym for BUSTLE","What is the synonym for ESTEEM","What is the synonym for INAUGRATE","What is the synonym for RAVISHING","What is the synonym for WICKED","What is the synonym for INFURIATE","What is the synonym for ANSWER",
//        //ANTONYMS
//        "The antonym for ENORMOUS","The antonym for COMMISSIONED","The antonym for ARTIFICIAL","The antonym for EXODUS","The antonym for RELINQUISH","The antonym for EXPAND","The antonym for MORTAL","The antonym for QUIESCENT","The antonym for OBEYING","The antonym for FRADULENT","The antonym for FLAGITIOUS","The antonym for BELITTLE","The antonym for STARTLED","The antonym for BUSY","The antonym for FRESH","The antonym for CULPABLE","The antonym for RELUCTANT","The antonym for RESIST","The antonym for SUPERFLUOUS","The antonym for INCESSANT","The antonym for EXODUS",
//        //SPELLINGS
//        "Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.",
//        //ANALOGIES
//        "Odometer is to mileage as compass is to","Marathon is to race as hibernation is to","Window is to pane as book is to","Cup is to coffee as bowl is to","Yard is to inch as quart is to","Elated is to despondent as enlightened is to","Optimist is to cheerful as pessimist is to","Reptile is to lizard as flower is to","Play is to actor as concert is to","Sponge is to porous as rubber is to","Careful is to cautious as boastful is to","Pen is to poet as needle is to","Secretly is to openly as silently is to","Embarrassed is to humiliated as frightened is to","Pride is to lion as shoal is to",
//        //CLASSIFICATION
//        "Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.",
//        //VERBAL CLASSIFICATION
//        "Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?",
//        //FOOD
//        "The word 'coconut' comes from a 16th century Portuguese word 'cocos' meaning ?","In which year was Ben & Jerry's ice cream company established?","Up until about 400 years ago the majority of carrots eaten in Europe were ____ in color?","A tomato is a _____ ?","A calzone (sounds like kal-zone-ay) is a type of ?","A dried plum is properly known as a _____ ?","Strawberries, raspberries, peaches and cherries are all related to which type of flower?","The odd coloured fruits from a plant whose latin name is Musa Velutina are ____ ?","The first breakfast cereal (invented in 1863) was not popular because ?","From which country do potatoes originate?"
//};
//    String a[]={
//            // INTERNATIONAL BRANDS
//            "ConAgra","Italy","1974","$625","Leo","Henry Ford","Pink","VISA","It's the Real Thing","L'Oreal","Nestle Crunch",
//            "Alfa-Romeo","Sweet Tarts","NASA","Wal-Mart","Australia","Hanuta","AOL","NetFlix","Embraer","Rochefort","New York","IBM",
//            //INDIAN BRANDS
//            "P & G","Jam","Parle","Poppins","Fanta","Soap","Godrej","Kotak Mahindra Bank","Johnson’s baby shampoo","P & G","Cipla","Fruit Juice",
//            "Britannia","Soft drink","Jaypee Group","Base Corporation","Toshiba","Vinod Khanna","Pepsico",
//            //BUSINESS
//            "Indian State Bank","Pepsi","Glen Mc Wrath","Hindustan Chip Limited","Kolkata","Cyrus P Mistry","Associated Cement Companies","Kolkata","1994",
//            "ICICI Bank","Canada","Greece","SnapDeal","Bank of Maharashtra","Tata Consultancy Services","Spices","Belgium","Hengsans","High Strategy","Reduction of",
//            "International Business Machines","Yahoo","2006","Bengaluru",
//            //ECONOMICS
//            "Max Muller","Socialistic Economy","Max Muller","Max Muller","Price Theory","Adam Smith","Only land","Price of commodity is an independent variable",
//            "Zero","Minimum","Power to satisfy a want","Increasing","Zero","Law of equi-marginal utility","Value in use","Law of diminishing marginal utility",
//            "External Total For","Multi-currency & Activation","President","Any factor",
//            //CURRENCY
//            "Afghan afghani", "Sloty", "Dram", "Euro", "Angolan kwanzarial","US Dollar"," Argentine manat", "Armenian ruble", "Australian pound",
//            "Austrian sloty","Azerbaijani florin","Bahamian dollar","Bahraini rupee","Bangladeshi taka"," Barbadian dollar"," Vatican City Liira",
//            " Yemeni dirham"," Moroccan rand","Nepalese rupee","Krone","New Zealand dollar" ,"Euro",
//            //WORLD CAPITALS
//            "Georgia","Croatia","Georgia","Croatia","Iraq","Bermuda","India","South Korea","Andorra","Jamaica","Austria","Honduras","Norway",
//            "France","Equador","Peru","Lebanon","Uruguay","Nicaragua","Tanzania","Bulgaria","Poland","Taiwan",
//            //WORLD MOUNTAINS
//            "United States","Scotland/U K","France-Germany","Europe","Mexico","Nepal","Nepal","Nepal-China","Japan","Philippines","Morocco",
//            "Asia","Austria alone","United States","Russia",
//            //WORLDS LAKES
//            "Kazakhstan","Canada-United States","Uganda","Canada","Canada","Kazakhstan","France","Peru","Finland","Canada","United States",
//            "Malaysia","Finland","Canada-United States","North America",
//            //ARITHMETIC APTITUDE
//            "3.6","300kmph","50km","100kmph","9","1 hour","220 km","70 km/hr","35.55 km/hr","17 6/7 km/hr","5 kmph","8 kmph","2 : 3","14 km",
//            "Sterling 460","2 : 5","Euro 500","2 : 3 : 4","20 litres","8 : 9","1.12",
//            //PERCENTAGE
//            "39, 30","588 apples","1","A is smaller than B","80","34%","2700","57%","Euro 15","4.37%",
//            //SERIES
//            "(1/3)","7","20","22","12","14","26","7","9","15","4.2","52","11","205","404","20","108","8",
//            //SYNONYMS
//            "Enormous","Start","Story","Crawl","Truthful","Quantity","Portion","Skirmish","Parental","Lazy","Married","Scribble","Clean","Body","Rule","Launch","Hungry","Good","Influx","Stout",
//            //ANTONYMS
//            "Soft","Started","Red","Influx","Abdicate","Convert","Divine","Active","Ordering","Candid","Innocent","Criticize","Amused","Occupied","Faulty","Defendable","wanting","fight","important","intermittent","invasion",
//            //SPELLINGS
//            "Efficient","Foreign","Ommineous","Pessenger","Benefitted","Treachrous","Forcast","Rigerous","Palete","Bouquete","Vetarinary","Chancelary","Excessive","Indipensable","Humorous",
//            //ANALOGIES
//            "speed","winter","novel","dish","gallon","aware","gloomy","petal","symphony","massive","arrogant","thread","scarcely","terrified","teacher",
//            //CLASSIFICATION
//            "Chicken","Cap","Kiwi","Curd","Potassium","Tea","Hangar","Sparrow","Tall","Pear","Dagger","Deck","Producer","Tricycle","Chameleon",
//            //VERBAL CLASSIFICATION
//            "parsley","inch","tyre","tulip","rye","guitar","dodge","branch","street","heading","tape","leopard","couch","cornea","noun","book","unimportant",
//            //FOOD
//            "angry face","1958","White","Fruit","Potato","Prune","Rose","pink bananas","it was green","Ireland"
//    };
//    String b[]={
//            // INTERNATIONAL BRANDS
//            "General Mills","Germany","1976","$6,250","Larry","Charles Rolls","Green","Discover","Coca-Cola..Real","Revlon","Twix",
//            "Infiniti","Smarties","Audi","Kmart","United States","Milka","Google","Rakuten","Airbus","Leffe","Detroit","Tata",
//            //INDIAN BRANDS
//            "Hindustan Unilever", "Noodles","ITC","KrackJack","Sprite","Shampoo","Procter & Gamble","ICICI Bank","Dove shampoo","Dabur","P & G",
//            "Tooth Paste","Parle","Nail polish","Tata Group","Hindustan Unilever","Sony","Salman Khan","Dabur",
//            // BUSINESS
//            "State Bank of Hindustan","Coca-Cola","Brett Lee","Hindustan Computer Limited","Ahmedabad","N Chandrasekaran","Association of Cement Companies","Chennai","1988",
//            "HDFC Bank","England","Canada","FlipKart","Vijaya Bank","Tata Corporate Services","Food","Bulgaria","HKI","Holmes and Stevenson","Oil of",
//            "International Business Models","Microsoft","2000","Mumbai",
//            // ECONOMICS
//            "Adam Smith","Gandhian Economy","Adam Smith","Adam Smith","Income Theory","J.B. Say","Only capital","Quantity demanded is a dependent variable",
//            "Negative","Average","Usefulness","Maximum","Positive","Law of equi-product","Value in exchange","Law of equi-marginal utility",
//            "Excellent Travel Fund","Maintenance & Advice","Vice President","Capital only",
//            //CURRENCY
//            "Afghani rupiya", "Lek" , "Algerian Dollar", "Andorran Dollar", "Angolan peso", "Caribbean Peso"," Argentine pound",
//            "Armenian dollar","Australian dollar", "Austrian dollar", "Azerbaijani dram", "Bahamian pound", "Bahraini dinar", "Bangladeshi rupee",
//            " Barbadian peseta"," Vatican City Peso"," Yemeni franc"," Moroccan dollar", "Nepalese dollar","Liire"," New Zealand rupee",
//            "Deutsche Mark",
//            //WORLD CAPITALS
//            "Haiti","Costa Rica","Gabon","Cuba","Iran","Bolivia","New Guyana","North Korea","Ukraine","Jordan","Australia","Haiti",
//            "Denmark","Honduras","Czech Republic","Oman","Latvia","Turkey","Peru","Senegal","Romania","Czech Republic","Tanzania",
//            //WORLD MOUNTAINS
//            "Japan","Canada","Italy-France","Antarcitica","Canada","Tanzania","India","China-India","India","United States","South-Africa","South-America",
//            "Switzerland alone","Russia","Turkey",
//            //WORLDS LAKES
//            "Russia","Mexico-United States","Kenya","Hungary","United States","Russia","Poland","Kenya","Sweden","United States",
//            "Canada","China","Iceland","Russia-China","Asia",
//            //ARITHMETIC APTITUDE
//            "7.2","30kmph","56km","110kmph","10","2 hours","224 km","75 km/hr","36 km/hr","25 km/hr","6 kmph","11 kmph","3 : 2","15 km","Sterling 484",
//            "3 : 5","Euro 1500","6 : 7 : 8","30 litres","17 : 18","1.2",
//            //PERCENTAGE
//            "41, 32","600 apples","14","A is greater than B","100","44%","2900","60%","Euro 15.7","5%",
//            //SERIES
//            "(1/8)","10","22","24","14","15","28","10","29","14","4.4","56","12","208","414","25","148","10",
//            //SYNONYMS
//            "Wrong","Release","Weak","Ball","Easy","Everything","Almost","Position","Seaming","Urgent","Spellbinding","Marks","Clothing","Break","Remarkable","Invest","Ripped","Bad","Enrage","Retort",
//            //ANTONYMS
//            "Average","Closed","Natural","Home-coming","Renounce","Condense","Immortal","Dormant","Following","Direct","Vapid","Flatter","Relaxed","Engrossed","Sluggish","Blameless","willing","accept","relevant","harsh","entry",
//            //SPELLINGS
//            "Treatmeant","Foreine","Omineous","Passenger","Benifited","Trecherous","Forecaste","Rigourous","Palet","Bouquette","Veteninary","Chancellery","Exccessive","Indipenseble","Ganerous",
//            //ANALOGIES
//            "hiking","bear","glass","soup","ounce","ignorant","mean","stem","musician","solid","humble","button","impolitely","agitated","student",
//            //CLASSIFICATION
//            "Snake","Turban","Eagle","Butter","Silicon","Cinchona","Platform","Swan","Huge","Apple","Hammer","Quay","Director","Trident","Crocodile",
//            //VERBAL CLASSIFICATION
//            "basil","ounce","steering wheel","rose","sourdough","flute","flee","dirt","freeway","body","twine","cougar","rug","retina","preposition","index","trivial",
//            //FOOD
//            "weeping face","1978","Red","Vegetable","Peach","Raisin","Lily","pink oranges","it was very expensive","South America"
//    };
//    String c[]={
//            // INTERNATIONAL BRANDS
//            "Kraft Heinz","United States","1978","$62,500","Lou","Karl Benz","Orange","American Express","Coke. Really the best","Cover Girl","Milky Way",
//            "BMW","Pop Rocks","Lucky Strike","Target","Italy","Kinder","Yahoo","eBay","Boeing","Chimay","Las Vegas","Virgin",
//            //INDIAN BRANDS
//            "Godrej","Health Drink","Hindustan Unilever","Mango Bite","Slice","Hair color","ITC","South Indian Bank","Himalaya baby shampoo","Nirma","Ranbaxy","Hair color",
//            "ITC","Toilet soap","ITC Group","P & G","Microsoft","Akshay Kumar","Hindustan Unilever",
//            //BUSINESS
//            "Imperial Bank of India","Thumbs Up","Michael Clark","Hindustan Corporation Limited","Mumbai","Ratan Tata","Associated Cementrics Corporation","Mumbai","1990",
//            "Bank Of Baroda","Russia","Greenland","eBay","Axis Bank","Tata Consulting Services","Furniture","Bermuda","HKS","Housing & Securities","Tincture of",
//            "International Biometric Machines","Google","2002","Kolkata",
//            //ECONOMICS
//            "Karl Marx","Mixed Economy","Karl Marx","Karl Marx","Employment Theory","J.M. Keynes","Both land & capital","Reciprocal relationship is found between price and quantity demanded",
//            "Infinite","Zero","Willingness of a person","Falling","Maximum","Theory of indifference curve","Both of above","Law of proportions",
//            "Existing Trade Fund","Money & Action","Prime Minister","Land only",
//            //CURRENCY
//            "Afghan Dollar", "Kwanza", "Algerian Dinar", "Andorran Sekel", "Angolan pound", "East Caribbean Dollar"," Argentine peso",
//            "Armenian sole", "Australian euro","Euro","Azerbaijani manat", "Bahamian peso", "Bahraini peseta", "Bangladeshi renmin", " Barbadian franc",
//            "Euro"," Yemeni rial"," Moroccan liire", "Nepalese tugarg","Euro"," New Zealand pound","German Mark",
//            //WORLD CAPITALS
//            "Iceland","Estonia","Guatemala","Congo","Kenya","Argentina","Kuwait","Kazakhstan","Afghanistan","Iceland","Angola","Hungary","Netherlands","Finland",
//            "Estonia","Qatar","Maldives","Uganda","Panama","Kenya","Hungary","Samoa","Sri Lanka",
//            //WORLD MOUNTAINS
//            "Philippines","Norway","Austria alone","Australia","Argentina","Somalia","Pakistan-China","Pakistan","Nepal","Canada","Algeria","North-America",
//            "Germany","Georgia","Romania",
//            //WORLDS LAKES
//            "Turkey","Cuba-United States","Tanzania","Russia","Russia","Canada","Germany","Nicaragua","Norway","Russia","Israel","Indonesia",
//            "Italy","United States-Mexico","Australia",
//            //ARITHMETIC APTITUDE
//            "8.4","600kmph","70km","120kmph","12","3 hours","230 km","84 km/hr","71.11 km/hr","30 km/hr","6.25 kmph","12 kmph","3 : 4","16 km",
//            "Sterling 550","4 : 5","Euro 2000","6 : 8 : 9","40 litres","21 : 22","1.25",
//            //PERCENTAGE
//            "42,33","688 apples","20","If x is smaller than y, then A is greater than B.","120","54%","3000","65%","Euro 19.7","6%",
//            //SERIES
//            "(2/8)","12","23","25","27","21","30","14","32","13","4.7","96","13","210","420","30","162","15",
//            //SYNONYMS
//            "Eraded","Length","Truthful","Eye-brow","Quandary","Share","Negative","Sullen","Gaze","Menacing","Boring","Thought","Messy","Return","Cherish","Graduate","Pretty","Weird","Engage","Putrid",
//            //ANTONYMS
//            "Tiny","Finished","Truthful","Return","Possess","Congest","Spiritual","Weak","Refusing","Forthright","Ignorant","Exaggerate","Endless","Relaxed","Disgraceful","Careless","anxious","welcome","significant","soft","immigration",
//            //SPELLINGS
//            "Reterment","Fariegn","Ominous","Pasanger","Benefited","Trechearous","Forcaust","Regorous","Palate","Bouquet","Vetinary","Chancelery","Exxcesive","Indispansible","Pupolous",
//            //ANALOGIES
//            "needle","dream","cover","spoon","milk","miserable","petty","daisy","piano","elastic","joyful","sewing","noisily","courageous","self-respect",
//            //CLASSIFICATION
//            "Swan","Helmet","Emu","Oil","Zirconium","Rubber","Dock","Parrot","Thin","Orange","Knife","Stern","Investor","Trifle","Alligator",
//            //VERBAL CLASSIFICATION
//            "dill","centimeter","engine","bud","pumpernickel","violin","duck","leaf","interstate","letter","cord","elephant","table","pupil","punctuation","glossary","insignificant",
//            //FOOD
//            "grinning face","1988","Orange","Herb","Pizza","Date","Daffodil","pink pineapples","it had to be soaked overnight","Greenland"
//
//    };
//    String d[]={
//            // INTERNATIONAL BRANDS
//            "Kellogs","United Kingdom","1980","$625,000","Luke","Gottlieb Daimler","Yellow","Master Card","Make It Real","Maybelline","Kit Kat",
//            "Lexus","Twizzlers","Word Press","CVS","France","Manner","Ask Jeeves","Amazon","Tupolev","Kronenbourg","Dallas","EMI",
//            //INDIAN BRANDS
//            "ITC","Chocolate","Britannia","All of these","Mountain Dew","Liquid Blue","Nirma","Axis Bank","Garnier shampoo","Hindustan Unilever","Johnson","Shampoo","Patanjali",
//            "Hair color","Reliance group","Exide","Samsung","Shahrukh Khan","ITC",
//            // BUSINESS
//            "Indian Imperial Bank","Red Bull","Adam Gilchrist","Hindustani Computer Limited","Bengaluru","None of above","None of above","Bengaluru","1992",
//            "Axis Bank","Japan","Atlanta","Koovs","Punjab National Bank","Tokyo Consulting Services","Electronics","Britain","Hangseng","HongKong & Shanghai","Aroma of",
//            "Indian Business Machines","Orkut","2004","Chennai",
//            // ECONOMICS
//            "None of these above","Free Economy","None of these above","Robbins","None of these above","All of the above","Neither land nor capital","All of the above",
//            "Positive","Negative","Harmfulness","Minimum","Negative","Law of diminishing marginal utility","None of above","All of the above",
//            "Exchange Traded Fund","Mergers & Acquisitions","Finance Minister","Labour only",
//            //CURRENCY
//            "Afghan yen", "Ruble", "Taka", "Andorran Pound", "Angolan kwanza", "Karbo", "Argentine dollar","Armenian dram","Australian renmin",
//            "Austrian dinar", "Azerbaijani ruble", "Bahamian pestas", "Bahraini pula", "Bangladeshi dollar", " Barbadian pound","Swiss Franc"," Yemeni dinar",
//            " Moroccan dirham", "Nepalese yuan","Franc","Australian Dollar" ,"German Franc",
//            //WORLD CAPITALS
//            "Egypt","Fiji","Indonesia","Chile","Kosovo","Armenia","Kygyyztan","Hungary","Azerbaijan","Ireland","Andorra","Eritrea","Latvia","Georgia","Lithuania",
//            "Nepal","Malta","Vanuatu","Paraguay","Somalia","Montenegro","San Marino","Slovakia",
//            //WORLD MOUNTAINS
//            "Indonesia","Holland","Switzerland alone","North America","Peru","South-Africa","Japan","Bangladesh","Indonesia","Venezuela","Kenya",
//            "Antarcitica","Poland","Canada","China",
//            //WORLDS LAKES
//            "Iran","Russia-China","Democratic Republic of the Congo","Mongolia","South Africa","Ivory Coast","Russia","Democratic Republic of the Congo",
//            "Greenland","Kazakhstan","Iran","Philippines","Singapore","Mongolia-China","Europe",
//            //ARITHMETIC APTITUDE
//            "10","720kmph","80km","130kmph","20","4 hours","234 km","87.5 km/hr","71 km/hr","35 km/hr","7.5 kmph","14 kmph","4 : 3","17 km","Sterling 664",
//            "6 : 7","Euro 1000","3 : 5 : 4","60 litres","Cannot be determined","1.30",
//            //PERCENTAGE
//            "43,34","700 apples","21","None of these","60","64%","3100","90%","Euro 20","8.75%",
//            //SERIES
//            "(1/16)","13","26","26","53","23","32","15","34","12","5.1","128","14","211","445","50","216","20",
//            //SYNONYMS
//            "Weak","Grasp","Plant","Hurry","Denial","Discussion","Dapper","Advise","Leach","Active","Understanding","Slay","Conceal","Hurry","Menacing","Readiness","Odd","Strange","Manage","Mettlesome",
//            //ANTONYMS
//            "Weak","Terminated","Solid","Restoration","Deny","Conclude","Eternal","Unconcerned","Contradicting","Genuine","Frivolous","Adore","Astonished","Engaged","Stale","Irresponsible","eager","repel","essential","constant","expulsion",
//            //SPELLINGS
//            "Employd","Forein","Omenous","pesanger","Benefeted","Treacherous","Forecast","Rigorous","Pelate","Boqquet","Veterinary","Chancellary","Excesive","Indispensable","Maretorious",
//            //ANALOGIES
//            "direction","sleep","page","food","liquid","tolerant","helpful","alligator","percussion","inflexible","suspicious","tailor","quietly","reckless","fish",
//            //CLASSIFICATION
//            "Crocodile","Veil","Ostrich","Cheese","Gallium","Chalk","Park","Koel","Sharp","Guava","Sword","Bow","Financier","Tricolour","Locust",
//            //VERBAL CLASSIFICATION
//            "mayonnaise","yard","car","daisy","loaf","cello","avoid","root","expressway","closing","yarn","lion","chair","vision","adverb","chapter","familiar",
//            //FOOD
//            "None of the above","1998","Green","None of the above","Cake","Fig","Tulip","pink mango","it was not tasty","Ethiopia",
//    };
//    int ans[]={
//            // INTERNATIONAL BRANDS(1-23)
//            1,3,2,4,2,1,4,1,3,1,4,1,4,2,3,3,3,3,3,2,4,2,3,
//            //INDIAN BRANDS(24-42)
//            2,1,4,4,3,4,2,1,1,2,2,2,2,4,2,3,3,4,4,
//            //BUSINESS(43-66)
//            3,1,3,2,4,2,1,2,4,1,3,4,2,4,1,3,2,4,4,2,1,2,4,3,
//            //ECONOMICS(67-86)
//            2,3,2,4,1,3,3,4,2,3,1,2,1,1,1,1,4,4,3,1,
//            //CURRENCY(87-108)
//            1,2,3,1,4,3,3,4,2,3,3,1,2,1,1,3,3,4,1,3,1,2,
//            //WORLD CAPITALS(109-130)
//            4,1,1,4,2,3,1,2,3,3,2,2,2,3,3,4,1,2,2,4,2,1,3,
//            //WORLD MOUNTAINS(131-147)
//            1,1,2,2,3,2,3,1,3,2,2,1,2,4,4,
//            //WORLDS LAKES(148-162)
//            3,1,4,3,1,3,4,1,2,1,1,2,1,1,2,
//            //ARITHMETIC APTITUDE(163-183)
//            2,4,1,3,2,1,2,4,3,4,1,3,3,3,2,3,3,1,4,3,2,
//            //PERCENTAGE(184-193)
//            3,4,3,4,2,4,1,1,3,2,
//            //SERIES(194-211)
//            2,2,2,3,2,2,2,4,4,1,3,2,2,4,1,1,3,1,
//            //SYNONYMS(212-231)
//            2,4,1,4,3,3,4,3,3,1,2,3,4,4,3,1,3,2,2,2,
//            //ANTONYMS(232-242)
//            3,4,2,1,3,2,2,1,1,4,1,3,2,3,4,2,2,3,2,1,2,
//            //SPELLINGS(243-257)
//            1,1,3,2,3,4,4,4,3,3,4,2,1,4,1,
//            //ANALOGIES(258-272)
//            4,4,4,2,2,2,1,3,2,3,1,4,3,1,4,
//            //CLASSIFICATION(273-287)
//            1,4,2,3,1,4,4,2,4,3,2,2,2,3,4,
//            //VERBAL CLASSIFICATION(288-304)
//            4,2,4,3,1,2,2,2,1,3,1,3,2,4,3,1,4,
//            //FOOD(305-314)
//            3,2,1,1,3,1,1,1,3,2
//    };
            // DATABASE 2
//String q[]={
//        // INTERNATIONAL BRANDS
//        "Which parent company owns brands such as Orville Redenbacher popcorn, Swiss Miss cocoa and Peter Pan peanut butter?",
//        "Despite its Danish sounding name, the ice cream Haagen Dasz is made in which country?",
//        "When was the first Apple logo introduced?",
//        "How much did the logo design for the London Olympic games cost?",
//        "What is the real name of Twitter Bird?",
//        "Which famous car maker said that people could have any color of the Model T so long as it was black?",
//        "What color is the square on the Post-It logo?",
//        "What credit card says: \"everywhere you want to be\"?",
//        "Which of these is NOT a tagline that has been used by Coca-Cola over the last 100 years?",
//        "What cosmetic company says: \"Because You Are Worth It\"?",
//        "\"Gimme a Break\" can be associated with what candy bar?",
//        "What car company uses a family coat of arms as their logo?",
//        "What type of candy \"Makes Your Mouth Happy\"?",
//        "The Olympic Committee sued which company over their logo?",
//        "Where can you \"Expect More. Pay Less. \"?",
//        "What country is responsible for the production of Maserati brand?",
//        "Which chocolatier makes two eggs: the \"Surprise\" which contains a toy and the \"Joy\" with white and milk chocolate?",
//        "\"Jerrys Guide to the World Wide Web\" was once the name of what well known company?",
//        "PayPal is a subsidiary of which company?",
//        "Which French-based aerospace company produces the A380, the world largest passenger airliner?",
//        "Which of these is NOT a well-known beer brewed in Belgium?",
//        "Where in America did Ford first start producing cars?",
//        "Richard Branson founded which business empire?",
//        //INDIAN BRANDS
//        " Soap brand \"Pears\" is product of ?"," Kissan brand is associated with which type of product?",
//        " Tiger brand biscuits are manufactured by ?","  Which of the following product(s) are manufactured by Parle ?",
//        " Which of the following is a Mango flavored soft drink ?","  Ujala is a _______ brand ?",
//        "Ariel detergent brand is owned by ?","  Savings account for Kids My Junior Account is offered by which of the following bank ?",
//        " \"No more tears\" is a tagline of which of the following  ?","Hair Care product Vatika brand owned by ?",
//        "Therapeutic brand \"Vicks\" associated with","Brand name Meswak is used to market which product ?",
//        "KrackJack biscuits are manufactured by?","with brand name Wella which product is manufactured ?",
//        "Hotel Chain Ginger is owned by which group ?","Duracell Batteries are manufactured by by?",
//        "Digital media product brand Zune is associated with which company ?",
//        "First indian male actor to model for Lux soap ?","B Natural fruit Juices are manufactured by?",
//        //BUSINESS IN INDIA
//        "State bank of India previously known as ?",
//        "Which soft drink brand was endorsed by Michael Jackson ?",
//        "Who is the first cricketer to endorse Hublot watches ?",
//        "Full form of IT company HCL ?",
//        "Canara bank head quarters is located in which city ?",
//        "Who is chairman of Tata group ?",
//        "Full form of ACC cement company ?",
//        "Bank of India Headquarters is located in which Indian city ?",
//        "In which year NSE(National Stock exchange) established ?",
//        "Which Indian Private sector bank first issued Contact less debt and Credit cards ?",
//        "MTS is largest mobile operator in which country ?",
//        "Coca-Cola head quarters is located at which city ?",
//        "Which e-Commerce company acquired Fashion brand and online store Myntra ?",
//        "\"The name you can bank upon\" is the tagline of which Indian Public sector bank tagline ?",
//        "Full form of TCS is ?",
//        "What products Pepperfry.com sells online ?",
//        "Unique in diversity is Which country tourism tagline ?",
//        "What is the name of Hong Kong Stock Market Index ?",
//        "HSBC is a \"Banking Corporation.\" What does the HS stand for?",
//        "In 2000, Olay dropped what two words from its brand name?",
//        "What is the full form of IBM ?",
//        "Search Engine Bing is owned by ?",
//        "In which year Yes bank was founded ?",
//        "Indian Conglomerate ITC head quarters is located in which Indian city ?",
//        //ECONOMICS
//        "Who is the father of Economics ?",
//        "Indian Economy is :",
//        "\"An Enquiry into the Nature and Causes of Wealth of Nations\" is the book of economist-",
//        "Who has given scarcity definition of economics ?",
//        "Which theory is generally included under micro economics ?",
//        "Whose opinions have revolutionised the scope of macro economics ?",
//        "Passive factor of production is ",
//        "Under law of demand ",
//        "For inferior commodities, income effect is",
//        "When total utility becomes maximum, then marginal utility will be",
//        "Utility means ",
//        "Marginal utility is equal to average utility at that time when average utility is",
//        "At point of satiety, marginal utility is",
//        "Which of the following is the second law of Gossen?",
//        "Total utility of a commodity is measured by which price of that commodity ?",
//        "According to Marshall, the basis of consumer surplus is",
//        "In investment management, what does the acronym ETF stand for?",
//        "In finance, what does M&A commonly stand for?",
//        "Who is the chairman of Planning Commission of India?",
//        "According to Modern Theory of Rent, rent accrues to ",
//        //CURRENCY
//        "What is the national currency of Afghanistan?", "What is the national currency of Albania?",
//        " What is the national currency of Algeria?","What is the national currency of Andorra?",
//        " What is the national currency of Angola?"," What is the national currency of Antigua and Barbuda?",
//        " What is the national currency of Argentina?"," What is the national currency of Armenia?",
//        " What is the national currency of Australia?"," What is the national currency of Austria?",
//        " What is the national currency of Azerbaijan?"," What is the national currency of The Bahamas?",
//        " What is the national currency of Bahrain?"," What is the national currency of Bangladesh?",
//        " What is the national currency of Barbados?"," What is the national currency of Vatican City?",
//        " What is the national currency of Yemen?"," What is the national currency of Morocco?",
//        " What is the national currency of Nepal?"," What is the national currency of Netherlands?",
//        " What is the national currency of Germany?",
//        //WORLD CAPITALS
//        "Cairo is the capital of which country?","Zagreb is the capital of which country?","Tbilisi is the capital of which country?","Santiago is the capital of which country?","Tehran is the capital of which country?","Buenos Aires is the capital of which country?","New Delhi is the capital of which country?","Pyongyang is the capital of which country?","Kabul is the capital of which country?",
//        "Reykjavik is the capital of which country?","Canberra is the capital of which country?","Port-au-Prince is the capital of which country?","Copenhagen is the capital of which country?","Helsinki is the capital of which country?","Tallinn is the capital of which country?",
//        "Kathmandu is the capital of which country?","Beirut is the capital of which country?","Ankara is the capital of which country?","Lima is the capital of which country?","Mogadishu is the capital of which country?","Bucharest is the capital of which country?",
//        "Warsow is the capital of which country?","Colombo is the capital of which country?",
//        //WORLD MOUNTAINS
//        "Mauna Kea is in which country/countries?","Ben Nevis is in which country/countries?","Mont Blanc is in which country/countries?","Vinson Massif is on which continent?","Aconcagua is in which country/countries?","Kilimanjaro is a mountain in which country/countries?",
//        "K2 is a mighty mountain in which country/countries?","Mount Everest is in which country/countries?","The mountain Annapurna is in which country/countries?","Mount McKinley is in which country/countries?","Table Mountain is in which country/countries?","Kailas is on which continent?",
//        "Bishorn is in which country/countries?","Mount Logan - Yukon is in which country/countries?","Shishapangma is in which country/countries?",
//        //WORLDS LAKES
//        "The Caspian Sea is NOT neighboured by which of the countries?","Michigan-Huron lake is between these countries?","Lake Victoria is NOT neighboured by this country?","Lake Baikal is the deepest lake in the world. In which country is it?",
//        "The Great Bear Lake is in which country?","The Great Slave Lake is in which country?","Ladoga is the largest lake in Europe. In which country is this?","Titicaca is one of the highest lakes in the world. Which country does neighbour it?","In which country is Vanern?",
//        "Winnipegosis is a lake in which country?","Great Salt Lake is in which country?","Qinghai Lake is the largest lake in East Asia. In which country is it?",
//        "Saimaa is a large lake with numerous basins and 14,000 islands. Where is this?","Lake of the Woods is neighboured by these countries.","Khanka is a lake on which continent?",
//        //ARITHMETIC APTITUDE
//        "A person crosses a 600 m long street in 5 minutes. What is his speed in km per hour?","An aeroplane covers a certain distance at a speed of 240 kmph in 5 hours. To cover the same distance in 1 2/3 hours, it must travel at a speed of:",
//        "If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more. The actual distance travelled by him is: ","A train can travel 50% faster than a car. Both start from point A at the same time and reach point B 75 kms away from A at the same time. On the way, however, the train lost about 12.5 minutes while stopping at the stations. The speed of the car is:",
//        "Excluding stoppages, the speed of a bus is 54 kmph and including stoppages, it is 45 kmph. For how many minutes does the bus stop per hour?",
//        "In a flight of 600 km, an aircraft was slowed down due to bad weather. Its average speed for the trip was reduced by 200 km/hr and the time of flight increased by 30 minutes. The duration of the flight is: ",
//        "A man complete a journey in 10 hours. He travels first half of the journey at the rate of 21 km/hr and second half at the rate of 24 km/hr. Find the total journey in km.",
//        "The ratio between the speeds of two trains is 7 : 8. If the second train runs 400 kms in 4 hours, then the speed of the first train is: ",
//        "A man on tour travels first 160 km at 64 km/hr and the next 160 km at 80 km/hr. The average speed for the first 320 km of the tour is:",
//        "A car travelling with 5/7 of its actual speed covers 42 km in 1 hr 40 min 48 sec. Find the actual speed of the car.",
//        "In covering a distance of 30 km, Celine takes 2 hours more than Sam. If Celine doubles his speed, then he would take 1 hour less than Sam. Speed of Celine is: ",
//        "Robert is travelling on his cycle and has calculated to reach point A at 2 P.M. if he travels at 10 kmph, he will reach there at 12 noon if he travels at 15 kmph. At what speed must he travel to reach A at 1 P.M.? ",
//        "It takes eight hours for a 600 km journey, if 120 km is done by train and the rest by car. It takes 20 minutes more, if 200 km is done by train and the rest by car. The ratio of the speed of the train to that of the cars is: ",
//        "A farmer travelled a distance of 61 km in 9 hours. He travelled partly on foot @ 4 km/hr and partly on bicycle @ 9 km/hr. The distance travelled on foot is: ",
//        "A and B together have Sterling 1210. If 4/15 of amount of A is equal to 2/5 of amount of B, how much amount does B have? ",
//        "Two numbers are respectively 20% and 50% more than a third number. The ratio of the two numbers is: ","A sum of money is to be distributed among A, B, C, D in the proportion of 5 : 2 : 4 : 3. If C gets Euro 1000 more than D, what is share of B?",
//        "Seats for Mathematics, Physics and Biology in a school are in the ratio 5 : 7 : 8. There is a proposal to increase these seats by 40%, 50% and 75% respectively. What will be the ratio of increased seats? ","In a mixture 60 litres, the ratio of milk and water 2 : 1. If the this ratio is to be 1 : 2, then the quanity of water to be further added is: ",
//        "The ratio of the number of boys and girls in a college is 7 : 8. If the percentage increase in the number of boys and girls be 20% and 10% respectively, what will be the new ratio? ","If 0.75 : x :: 5 : 8, then x is equal to:",
//        //PERCENTAGE
//        "Two students appeared at an examination. One of them secured 9 marks more than the other and his marks was 56% of the sum of their marks. The marks obtained by them are: ","A fruit seller had some apples. He sells 40% apples and still has 420 apples. Originally, he had:","What percentage of numbers from 1 to 70 have 1 or 9 in the units digit?","In a certain school, 20% of students are below 8 years of age. The number of students above 8 years of age is 2/3 of the number of students of 8 years of age which is 48. What is the total number of students in the school?","A student multiplied a number by 3/5 instead of 5/3. What is the percentage error in the calculation?","In an election between two candidates, one got 55% of the total valid votes, 20% of the votes were invalid. If the total number of votes was 7500, the number of valid votes that the other candidate got, was: ","Three candidates contested an election and received 1136, 7636 and 11628 votes respectively. What percentage of the total votes did the winning candidate get? ","Helen went to the stationers and bought things worth Euro 25, out of which 30 paise went on sales tax on taxable purchases. If the tax rate was 6%, then what was the cost of the tax free items?","The population of a town increased from 1,75,000 to 2,62,500 in a decade. The average percent increase of population per year is: ",
//        //SERIES
//        "Look at this series: 2, 1, (1/2), (1/4), ... What number should come next?","Look at this series: 7, 10, 8, 11, 9, 12, ... What number should come next?","Look at this series: 36, 34, 30, 28, 24, ... What number should come next?","Look at this series: 22, 21, 23, 22, 24, 23, ... What number should come next?","Look at this series: 53, 53, 40, 40, 27, 27, ... What number should come next?","Look at this series: 21, 9, 21, 11, 21, 13, 21, ... What number should come next?","Look at this series: 58, 52, 46, 40, 34, ... What number should come next?","Look at this series: 3, 4, 7, 8, 11, 12, ... What number should come next?","Look at this series: 8, 22, 8, 28, 8, ... What number should come next?","Look at this series: 31, 29, 24, 22, 17, ... What number should come next?","Look at this series: 1.5, 2.3, 3.1, 3.9, ... What number should come next?","Look at this series: 14, 28, 20, 40, 32, 64, ... What number should come next?","Look at this series: 2, 4, 6, 8, 10, ... What number should come next?","Look at this series: 201, 202, 204, 207, ... What number should come next?","Look at this series: 544, 509, 474, 439, ... What number should come next?","Look at this series: 80, 10, 70, 15, 60, ... What number should come next?","Look at this series: 2, 6, 18, 54, ... What number should come next?","Look at this series: 1000, 200, 40, ... What number should come next?",
//        //SYNONYMS
//        "What is the synonym for ERRORNEOUS","What is the synonym for SEIZE","What is the synonym for FABLE","What is the synonym for DASH","What is the synonym for PREDICAMENT","What is the synonym for ALLOTMENT","What is the synonym for NEAT","What is the synonym for MOODY","What is the synonym for OGLE","What is the synonym for INDOLENT","What is the synonym for ENGAGING","What is the synonym for NOTION","What is the synonym for SHROUD","What is the synonym for BUSTLE","What is the synonym for ESTEEM","What is the synonym for INAUGRATE","What is the synonym for RAVISHING","What is the synonym for WICKED","What is the synonym for INFURIATE","What is the synonym for ANSWER",
//        //ANTONYMS
//        "The antonym for ENORMOUS","The antonym for COMMISSIONED","The antonym for ARTIFICIAL","The antonym for EXODUS","The antonym for RELINQUISH","The antonym for EXPAND","The antonym for MORTAL","The antonym for QUIESCENT","The antonym for OBEYING","The antonym for FRADULENT","The antonym for FLAGITIOUS","The antonym for BELITTLE","The antonym for STARTLED","The antonym for BUSY","The antonym for FRESH","The antonym for CULPABLE","The antonym for RELUCTANT","The antonym for RESIST","The antonym for SUPERFLUOUS","The antonym for INCESSANT","The antonym for EXODUS",
//        //SPELLINGS
//        "Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.",
//        //ANALOGIES
//        "Odometer is to mileage as compass is to","Marathon is to race as hibernation is to","Window is to pane as book is to","Cup is to coffee as bowl is to","Yard is to inch as quart is to","Elated is to despondent as enlightened is to","Optimist is to cheerful as pessimist is to","Reptile is to lizard as flower is to","Play is to actor as concert is to","Sponge is to porous as rubber is to","Careful is to cautious as boastful is to","Pen is to poet as needle is to","Secretly is to openly as silently is to","Embarrassed is to humiliated as frightened is to","Pride is to lion as shoal is to",
//        //CLASSIFICATION
//        "Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.",
//        //VERBAL CLASSIFICATION
//        "Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?",
//        //FOOD
//        "The word coconut comes from a 16th century Portuguese word cocos meaning ?","In which year was Ben & Jerry ice cream company established?","Up until about 400 years ago the majority of carrots eaten in Europe were ____ in color?","A tomato is a _____ ?","A calzone (sounds like kal-zone-ay) is a type of ?","A dried plum is properly known as a _____ ?","Strawberries, raspberries, peaches and cherries are all related to which type of flower?","The odd coloured fruits from a plant whose latin name is Musa Velutina are ____ ?","The first breakfast cereal (invented in 1863) was not popular because ?","From which country do potatoes originate?"
//};
//    String a[]={
//            // INTERNATIONAL BRANDS
//            "ConAgra","Italy","1974","$625","Leo","Henry Ford","Pink","VISA","It is the Real Thing","L Oreal","Nestle Crunch",
//            "Alfa-Romeo","Sweet Tarts","NASA","Wal-Mart","Australia","Hanuta","AOL","NetFlix","Embraer","Rochefort","New York","IBM",
//            //INDIAN BRANDS
//            "P & G","Jam","Parle","Poppins","Fanta","Soap","Godrej","Kotak Mahindra Bank","Johnson’s baby shampoo","P & G","Cipla","Fruit Juice",
//            "Britannia","Soft drink","Jaypee Group","Base Corporation","Toshiba","Vinod Khanna","Pepsico",
//            //BUSINESS
//            "Indian State Bank","Pepsi","Glen Mc Wrath","Hindustan Chip Limited","Kolkata","Cyrus P Mistry","Associated Cement Companies","Kolkata","1994",
//            "ICICI Bank","Canada","Greece","SnapDeal","Bank of Maharashtra","Tata Consultancy Services","Spices","Belgium","Hengsans","High Strategy","Reduction of",
//            "International Business Machines","Yahoo","2006","Bengaluru",
//            //ECONOMICS
//            "Max Muller","Socialistic Economy","Max Muller","Max Muller","Price Theory","Adam Smith","Only land","Price of commodity is an independent variable",
//            "Zero","Minimum","Power to satisfy a want","Increasing","Zero","Law of equi-marginal utility","Value in use","Law of diminishing marginal utility",
//            "External Total For","Multi-currency & Activation","President","Any factor",
//            //CURRENCY
//            "Afghan afghani", "Sloty", "Dram", "Euro", "Angolan kwanzarial","US Dollar"," Argentine manat", "Armenian ruble", "Australian pound",
//            "Austrian sloty","Azerbaijani florin","Bahamian dollar","Bahraini rupee","Bangladeshi taka"," Barbadian dollar"," Vatican City Liira",
//            " Yemeni dirham"," Moroccan rand","Nepalese rupee","Krone","New Zealand dollar" ,"Euro",
//            //WORLD CAPITALS
//            "Georgia","Croatia","Georgia","Croatia","Iraq","Bermuda","India","South Korea","Andorra","Jamaica","Austria","Honduras","Norway",
//            "France","Equador","Peru","Lebanon","Uruguay","Nicaragua","Tanzania","Bulgaria","Poland","Taiwan",
//            //WORLD MOUNTAINS
//            "United States","Scotland/U K","France-Germany","Europe","Mexico","Nepal","Nepal","Nepal-China","Japan","Philippines","Morocco",
//            "Asia","Austria alone","United States","Russia",
//            //WORLDS LAKES
//            "Kazakhstan","Canada-United States","Uganda","Canada","Canada","Kazakhstan","France","Peru","Finland","Canada","United States",
//            "Malaysia","Finland","Canada-United States","North America",
//            //ARITHMETIC APTITUDE
//            "3.6","300kmph","50km","100kmph","9","1 hour","220 km","70 km/hr","35.55 km/hr","17 6/7 km/hr","5 kmph","8 kmph","2 : 3","14 km",
//            "Sterling 460","2 : 5","Euro 500","2 : 3 : 4","20 litres","8 : 9","1.12",
//            //PERCENTAGE
//            "39, 30","588 apples","1","A is smaller than B","80","34%","2700","57%","Euro 15","4.37%",
//            //SERIES
//            "(1/3)","7","20","22","12","14","26","7","9","15","4.2","52","11","205","404","20","108","8",
//            //SYNONYMS
//            "Enormous","Start","Story","Crawl","Truthful","Quantity","Portion","Skirmish","Parental","Lazy","Married","Scribble","Clean","Body","Rule","Launch","Hungry","Good","Influx","Stout",
//            //ANTONYMS
//            "Soft","Started","Red","Influx","Abdicate","Convert","Divine","Active","Ordering","Candid","Innocent","Criticize","Amused","Occupied","Faulty","Defendable","wanting","fight","important","intermittent","invasion",
//            //SPELLINGS
//            "Efficient","Foreign","Ommineous","Pessenger","Benefitted","Treachrous","Forcast","Rigerous","Palete","Bouquete","Vetarinary","Chancelary","Excessive","Indipensable","Humorous",
//            //ANALOGIES
//            "speed","winter","novel","dish","gallon","aware","gloomy","petal","symphony","massive","arrogant","thread","scarcely","terrified","teacher",
//            //CLASSIFICATION
//            "Chicken","Cap","Kiwi","Curd","Potassium","Tea","Hangar","Sparrow","Tall","Pear","Dagger","Deck","Producer","Tricycle","Chameleon",
//            //VERBAL CLASSIFICATION
//            "parsley","inch","tyre","tulip","rye","guitar","dodge","branch","street","heading","tape","leopard","couch","cornea","noun","book","unimportant",
//            //FOOD
//            "angry face","1958","White","Fruit","Potato","Prune","Rose","pink bananas","it was green","Ireland"
//    };
//    String b[]={
//            // INTERNATIONAL BRANDS
//            "General Mills","Germany","1976","$6,250","Larry","Charles Rolls","Green","Discover","Coca-Cola..Real","Revlon","Twix",
//            "Infiniti","Smarties","Audi","Kmart","United States","Milka","Google","Rakuten","Airbus","Leffe","Detroit","Tata",
//            //INDIAN BRANDS
//            "Hindustan Unilever", "Noodles","ITC","KrackJack","Sprite","Shampoo","Procter & Gamble","ICICI Bank","Dove shampoo","Dabur","P & G",
//            "Tooth Paste","Parle","Nail polish","Tata Group","Hindustan Unilever","Sony","Salman Khan","Dabur",
//            // BUSINESS
//            "State Bank of Hindustan","Coca-Cola","Brett Lee","Hindustan Computer Limited","Ahmedabad","N Chandrasekaran","Association of Cement Companies","Chennai","1988",
//            "HDFC Bank","England","Canada","FlipKart","Vijaya Bank","Tata Corporate Services","Food","Bulgaria","HKI","Holmes and Stevenson","Oil of",
//            "International Business Models","Microsoft","2000","Mumbai",
//            // ECONOMICS
//            "Adam Smith","Gandhian Economy","Adam Smith","Adam Smith","Income Theory","J.B. Say","Only capital","Quantity demanded is a dependent variable",
//            "Negative","Average","Usefulness","Maximum","Positive","Law of equi-product","Value in exchange","Law of equi-marginal utility",
//            "Excellent Travel Fund","Maintenance & Advice","Vice President","Capital only",
//            //CURRENCY
//            "Afghani rupiya", "Lek" , "Algerian Dollar", "Andorran Dollar", "Angolan peso", "Caribbean Peso"," Argentine pound",
//            "Armenian dollar","Australian dollar", "Austrian dollar", "Azerbaijani dram", "Bahamian pound", "Bahraini dinar", "Bangladeshi rupee",
//            " Barbadian peseta"," Vatican City Peso"," Yemeni franc"," Moroccan dollar", "Nepalese dollar","Liire"," New Zealand rupee",
//            "Deutsche Mark",
//            //WORLD CAPITALS
//            "Haiti","Costa Rica","Gabon","Cuba","Iran","Bolivia","New Guyana","North Korea","Ukraine","Jordan","Australia","Haiti",
//            "Denmark","Honduras","Czech Republic","Oman","Latvia","Turkey","Peru","Senegal","Romania","Czech Republic","Tanzania",
//            //WORLD MOUNTAINS
//            "Japan","Canada","Italy-France","Antarcitica","Canada","Tanzania","India","China-India","India","United States","South-Africa","South-America",
//            "Switzerland alone","Russia","Turkey",
//            //WORLDS LAKES
//            "Russia","Mexico-United States","Kenya","Hungary","United States","Russia","Poland","Kenya","Sweden","United States",
//            "Canada","China","Iceland","Russia-China","Asia",
//            //ARITHMETIC APTITUDE
//            "7.2","30kmph","56km","110kmph","10","2 hours","224 km","75 km/hr","36 km/hr","25 km/hr","6 kmph","11 kmph","3 : 2","15 km","Sterling 484",
//            "3 : 5","Euro 1500","6 : 7 : 8","30 litres","17 : 18","1.2",
//            //PERCENTAGE
//            "41, 32","600 apples","14","A is greater than B","100","44%","2900","60%","Euro 15.7","5%",
//            //SERIES
//            "(1/8)","10","22","24","14","15","28","10","29","14","4.4","56","12","208","414","25","148","10",
//            //SYNONYMS
//            "Wrong","Release","Weak","Ball","Easy","Everything","Almost","Position","Seaming","Urgent","Spellbinding","Marks","Clothing","Break","Remarkable","Invest","Ripped","Bad","Enrage","Retort",
//            //ANTONYMS
//            "Average","Closed","Natural","Home-coming","Renounce","Condense","Immortal","Dormant","Following","Direct","Vapid","Flatter","Relaxed","Engrossed","Sluggish","Blameless","willing","accept","relevant","harsh","entry",
//            //SPELLINGS
//            "Treatmeant","Foreine","Omineous","Passenger","Benifited","Trecherous","Forecaste","Rigourous","Palet","Bouquette","Veteninary","Chancellery","Exccessive","Indipenseble","Ganerous",
//            //ANALOGIES
//            "hiking","bear","glass","soup","ounce","ignorant","mean","stem","musician","solid","humble","button","impolitely","agitated","student",
//            //CLASSIFICATION
//            "Snake","Turban","Eagle","Butter","Silicon","Cinchona","Platform","Swan","Huge","Apple","Hammer","Quay","Director","Trident","Crocodile",
//            //VERBAL CLASSIFICATION
//            "basil","ounce","steering wheel","rose","sourdough","flute","flee","dirt","freeway","body","twine","cougar","rug","retina","preposition","index","trivial",
//            //FOOD
//            "weeping face","1978","Red","Vegetable","Peach","Raisin","Lily","pink oranges","it was very expensive","South America"
//    };
//    String c[]={
//            // INTERNATIONAL BRANDS
//            "Kraft Heinz","United States","1978","$62,500","Lou","Karl Benz","Orange","American Express","Coke. Really the best","Cover Girl","Milky Way",
//            "BMW","Pop Rocks","Lucky Strike","Target","Italy","Kinder","Yahoo","eBay","Boeing","Chimay","Las Vegas","Virgin",
//            //INDIAN BRANDS
//            "Godrej","Health Drink","Hindustan Unilever","Mango Bite","Slice","Hair color","ITC","South Indian Bank","Himalaya baby shampoo","Nirma","Ranbaxy","Hair color",
//            "ITC","Toilet soap","ITC Group","P & G","Microsoft","Akshay Kumar","Hindustan Unilever",
//            //BUSINESS
//            "Imperial Bank of India","Thumbs Up","Michael Clark","Hindustan Corporation Limited","Mumbai","Ratan Tata","Associated Cementrics Corporation","Mumbai","1990",
//            "Bank Of Baroda","Russia","Greenland","eBay","Axis Bank","Tata Consulting Services","Furniture","Bermuda","HKS","Housing & Securities","Tincture of",
//            "International Biometric Machines","Google","2002","Kolkata",
//            //ECONOMICS
//            "Karl Marx","Mixed Economy","Karl Marx","Karl Marx","Employment Theory","J.M. Keynes","Both land & capital","Reciprocal relationship is found between price and quantity demanded",
//            "Infinite","Zero","Willingness of a person","Falling","Maximum","Theory of indifference curve","Both of above","Law of proportions",
//            "Existing Trade Fund","Money & Action","Prime Minister","Land only",
//            //CURRENCY
//            "Afghan Dollar", "Kwanza", "Algerian Dinar", "Andorran Sekel", "Angolan pound", "East Caribbean Dollar"," Argentine peso",
//            "Armenian sole", "Australian euro","Euro","Azerbaijani manat", "Bahamian peso", "Bahraini peseta", "Bangladeshi renmin", " Barbadian franc",
//            "Euro"," Yemeni rial"," Moroccan liire", "Nepalese tugarg","Euro"," New Zealand pound","German Mark",
//            //WORLD CAPITALS
//            "Iceland","Estonia","Guatemala","Congo","Kenya","Argentina","Kuwait","Kazakhstan","Afghanistan","Iceland","Angola","Hungary","Netherlands","Finland",
//            "Estonia","Qatar","Maldives","Uganda","Panama","Kenya","Hungary","Samoa","Sri Lanka",
//            //WORLD MOUNTAINS
//            "Philippines","Norway","Austria alone","Australia","Argentina","Somalia","Pakistan-China","Pakistan","Nepal","Canada","Algeria","North-America",
//            "Germany","Georgia","Romania",
//            //WORLDS LAKES
//            "Turkey","Cuba-United States","Tanzania","Russia","Russia","Canada","Germany","Nicaragua","Norway","Russia","Israel","Indonesia",
//            "Italy","United States-Mexico","Australia",
//            //ARITHMETIC APTITUDE
//            "8.4","600kmph","70km","120kmph","12","3 hours","230 km","84 km/hr","71.11 km/hr","30 km/hr","6.25 kmph","12 kmph","3 : 4","16 km",
//            "Sterling 550","4 : 5","Euro 2000","6 : 8 : 9","40 litres","21 : 22","1.25",
//            //PERCENTAGE
//            "42,33","688 apples","20","If x is smaller than y, then A is greater than B.","120","54%","3000","65%","Euro 19.7","6%",
//            //SERIES
//            "(2/8)","12","23","25","27","21","30","14","32","13","4.7","96","13","210","420","30","162","15",
//            //SYNONYMS
//            "Eraded","Length","Truthful","Eye-brow","Quandary","Share","Negative","Sullen","Gaze","Menacing","Boring","Thought","Messy","Return","Cherish","Graduate","Pretty","Weird","Engage","Putrid",
//            //ANTONYMS
//            "Tiny","Finished","Truthful","Return","Possess","Congest","Spiritual","Weak","Refusing","Forthright","Ignorant","Exaggerate","Endless","Relaxed","Disgraceful","Careless","anxious","welcome","significant","soft","immigration",
//            //SPELLINGS
//            "Reterment","Fariegn","Ominous","Pasanger","Benefited","Trechearous","Forcaust","Regorous","Palate","Bouquet","Vetinary","Chancelery","Exxcesive","Indispansible","Pupolous",
//            //ANALOGIES
//            "needle","dream","cover","spoon","milk","miserable","petty","daisy","piano","elastic","joyful","sewing","noisily","courageous","self-respect",
//            //CLASSIFICATION
//            "Swan","Helmet","Emu","Oil","Zirconium","Rubber","Dock","Parrot","Thin","Orange","Knife","Stern","Investor","Trifle","Alligator",
//            //VERBAL CLASSIFICATION
//            "dill","centimeter","engine","bud","pumpernickel","violin","duck","leaf","interstate","letter","cord","elephant","table","pupil","punctuation","glossary","insignificant",
//            //FOOD
//            "grinning face","1988","Orange","Herb","Pizza","Date","Daffodil","pink pineapples","it had to be soaked overnight","Greenland"
//
//    };
//    String d[]={
//            // INTERNATIONAL BRANDS
//            "Kellogs","United Kingdom","1980","$625,000","Luke","Gottlieb Daimler","Yellow","Master Card","Make It Real","Maybelline","Kit Kat",
//            "Lexus","Twizzlers","Word Press","CVS","France","Manner","Ask Jeeves","Amazon","Tupolev","Kronenbourg","Dallas","EMI",
//            //INDIAN BRANDS
//            "ITC","Chocolate","Britannia","All of these","Mountain Dew","Liquid Blue","Nirma","Axis Bank","Garnier shampoo","Hindustan Unilever","Johnson","Shampoo","Patanjali",
//            "Hair color","Reliance group","Exide","Samsung","Shahrukh Khan","ITC",
//            // BUSINESS
//            "Indian Imperial Bank","Red Bull","Adam Gilchrist","Hindustani Computer Limited","Bengaluru","None of above","None of above","Bengaluru","1992",
//            "Axis Bank","Japan","Atlanta","Koovs","Punjab National Bank","Tokyo Consulting Services","Electronics","Britain","Hangseng","HongKong & Shanghai","Aroma of",
//            "Indian Business Machines","Orkut","2004","Chennai",
//            // ECONOMICS
//            "None of these above","Free Economy","None of these above","Robbins","None of these above","All of the above","Neither land nor capital","All of the above",
//            "Positive","Negative","Harmfulness","Minimum","Negative","Law of diminishing marginal utility","None of above","All of the above",
//            "Exchange Traded Fund","Mergers & Acquisitions","Finance Minister","Labour only",
//            //CURRENCY
//            "Afghan yen", "Ruble", "Taka", "Andorran Pound", "Angolan kwanza", "Karbo", "Argentine dollar","Armenian dram","Australian renmin",
//            "Austrian dinar", "Azerbaijani ruble", "Bahamian pestas", "Bahraini pula", "Bangladeshi dollar", " Barbadian pound","Swiss Franc"," Yemeni dinar",
//            " Moroccan dirham", "Nepalese yuan","Franc","Australian Dollar" ,"German Franc",
//            //WORLD CAPITALS
//            "Egypt","Fiji","Indonesia","Chile","Kosovo","Armenia","Kygyyztan","Hungary","Azerbaijan","Ireland","Andorra","Eritrea","Latvia","Georgia","Lithuania",
//            "Nepal","Malta","Vanuatu","Paraguay","Somalia","Montenegro","San Marino","Slovakia",
//            //WORLD MOUNTAINS
//            "Indonesia","Holland","Switzerland alone","North America","Peru","South-Africa","Japan","Bangladesh","Indonesia","Venezuela","Kenya",
//            "Antarcitica","Poland","Canada","China",
//            //WORLDS LAKES
//            "Iran","Russia-China","Democratic Republic of the Congo","Mongolia","South Africa","Ivory Coast","Russia","Democratic Republic of the Congo",
//            "Greenland","Kazakhstan","Iran","Philippines","Singapore","Mongolia-China","Europe",
//            //ARITHMETIC APTITUDE
//            "10","720kmph","80km","130kmph","20","4 hours","234 km","87.5 km/hr","71 km/hr","35 km/hr","7.5 kmph","14 kmph","4 : 3","17 km","Sterling 664",
//            "6 : 7","Euro 1000","3 : 5 : 4","60 litres","Cannot be determined","1.30",
//            //PERCENTAGE
//            "43,34","700 apples","21","None of these","60","64%","3100","90%","Euro 20","8.75%",
//            //SERIES
//            "(1/16)","13","26","26","53","23","32","15","34","12","5.1","128","14","211","445","50","216","20",
//            //SYNONYMS
//            "Weak","Grasp","Plant","Hurry","Denial","Discussion","Dapper","Advise","Leach","Active","Understanding","Slay","Conceal","Hurry","Menacing","Readiness","Odd","Strange","Manage","Mettlesome",
//            //ANTONYMS
//            "Weak","Terminated","Solid","Restoration","Deny","Conclude","Eternal","Unconcerned","Contradicting","Genuine","Frivolous","Adore","Astonished","Engaged","Stale","Irresponsible","eager","repel","essential","constant","expulsion",
//            //SPELLINGS
//            "Employd","Forein","Omenous","pesanger","Benefeted","Treacherous","Forecast","Rigorous","Pelate","Boqquet","Veterinary","Chancellary","Excesive","Indispensable","Maretorious",
//            //ANALOGIES
//            "direction","sleep","page","food","liquid","tolerant","helpful","alligator","percussion","inflexible","suspicious","tailor","quietly","reckless","fish",
//            //CLASSIFICATION
//            "Crocodile","Veil","Ostrich","Cheese","Gallium","Chalk","Park","Koel","Sharp","Guava","Sword","Bow","Financier","Tricolour","Locust",
//            //VERBAL CLASSIFICATION
//            "mayonnaise","yard","car","daisy","loaf","cello","avoid","root","expressway","closing","yarn","lion","chair","vision","adverb","chapter","familiar",
//            //FOOD
//            "None of the above","1998","Green","None of the above","Cake","Fig","Tulip","pink mango","it was not tasty","Ethiopia",
//    };
//    int ans[]={
//            // INTERNATIONAL BRANDS(1-23)
//            1,3,2,4,2,1,4,1,3,1,4,1,4,2,3,3,3,3,3,2,4,2,3,
//            //INDIAN BRANDS(24-42)
//            2,1,4,4,3,4,2,1,1,2,2,2,2,4,2,3,3,4,4,
//            //BUSINESS(43-66)
//            3,1,3,2,4,2,1,2,4,1,3,4,2,4,1,3,2,4,4,2,1,2,4,3,
//            //ECONOMICS(67-86)
//            2,3,2,4,1,3,3,4,2,3,1,2,1,1,1,1,4,4,3,1,
//            //CURRENCY(87-108)
//            1,2,3,1,4,3,3,4,2,3,3,1,2,1,1,3,3,4,1,3,1,2,
//            //WORLD CAPITALS(109-130)
//            4,1,1,4,2,3,1,2,3,3,2,2,2,3,3,4,1,2,2,4,2,1,3,
//            //WORLD MOUNTAINS(131-147)
//            1,1,2,2,3,2,3,1,3,2,2,1,2,4,4,
//            //WORLDS LAKES(148-162)
//            3,1,4,3,1,3,4,1,2,1,1,2,1,1,2,
//            //ARITHMETIC APTITUDE(163-183)
//            2,4,1,3,2,1,2,4,3,4,1,3,3,3,2,3,3,1,4,3,2,
//            //PERCENTAGE(184-193)
//            3,4,3,4,2,4,1,1,3,2,
//            //SERIES(194-211)
//            2,2,2,3,2,2,2,4,4,1,3,2,2,4,1,1,3,1,
//            //SYNONYMS(212-231)
//            2,4,1,4,3,3,4,3,3,1,2,3,4,4,3,1,3,2,2,2,
//            //ANTONYMS(232-242)
//            3,4,2,1,3,2,2,1,1,4,1,3,2,3,4,2,2,3,2,1,2,
//            //SPELLINGS(243-257)
//            1,1,3,2,3,4,4,4,3,3,4,2,1,4,1,
//            //ANALOGIES(258-272)
//            4,4,4,2,2,2,1,3,2,3,1,4,3,1,4,
//            //CLASSIFICATION(273-287)
//            1,4,2,3,1,4,4,2,4,3,2,2,2,3,4,
//            //VERBAL CLASSIFICATION(288-304)
//            4,2,4,3,1,2,2,2,1,3,1,3,2,4,3,1,4,
//            //FOOD(305-314)
//            3,2,1,1,3,1,1,1,3,2
//    };
    // database 3
    String q[]={
            // INTERNATIONAL BRANDS
            "Which parent company owns brands such as Orville Redenbacher popcorn, Swiss Miss cocoa and Peter Pan peanut butter?",
            "Despite its Danish sounding name, the ice cream Haagen Dasz is made in which country?",
            "When was the first Apple logo introduced?",
            "How much did the logo design for the London Olympic games cost?",
            "What is the real name of Twitter Bird?",
            "Which famous car maker said that people could have any color of the Model T so long as it was black?",
            "What color is the square on the Post-It logo?",
            "What credit card says: \"everywhere you want to be\"?",
            "Which of these is NOT a tagline that has been used by Coca-Cola over the last 100 years?",
            "What cosmetic company says: \"Because You Are Worth It\"?",
            "\"Gimme a Break\" can be associated with what candy bar?",
            "What car company uses a family coat of arms as their logo?",
            "What type of candy \"Makes Your Mouth Happy\"?",
            "The Olympic Committee sued which company over their logo?",
            "Where can you \"Expect More. Pay Less. \"?",
            "What country is responsible for the production of Maserati brand?",
            "Which chocolatier makes two eggs: the \"Surprise\" which contains a toy and the \"Joy\" with white and milk chocolate?",
            "\"Jerrys Guide to the World Wide Web\" was once the name of what well known company?",
            "PayPal is a subsidiary of which company?",
            "Which French-based aerospace company produces the A380, the world largest passenger airliner?",
            "Which of these is NOT a well-known beer brewed in Belgium?",
            "Where in America did Ford first start producing cars?",
            "Richard Branson founded which business empire?",
            //INDIAN BRANDS
            " Soap brand \"Pears\" is product of ?"," Kissan brand is associated with which type of product?",
            " Tiger brand biscuits are manufactured by ?","  Which of the following product(s) are manufactured by Parle ?",
            " Which of the following is a Mango flavored soft drink ?","  Ujala is a _______ brand ?",
            "Ariel detergent brand is owned by ?","  Savings account for Kids My Junior Account is offered by which of the following bank ?",
            " \"No more tears\" is a tagline of which of the following  ?","Hair Care product Vatika brand owned by ?",
            "Therapeutic brand \"Vicks\" associated with","Brand name Meswak is used to market which product ?",
            "KrackJack biscuits are manufactured by?","with brand name Wella which product is manufactured ?",
            "Hotel Chain Ginger is owned by which group ?","Duracell Batteries are manufactured by by?",
            "Digital media product brand Zune is associated with which company ?",
            "First indian male actor to model for Lux soap ?","B Natural fruit Juices are manufactured by?",
            //BUSINESS IN INDIA
            "State bank of India previously known as ?",
            "Which soft drink brand was endorsed by Michael Jackson ?",
            "Who is the first cricketer to endorse Hublot watches ?",
            "Full form of IT company HCL ?",
            "Canara bank head quarters is located in which city ?",
            "Who is chairman of Tata group ?",
            "Full form of ACC cement company ?",
            "Bank of India Headquarters is located in which Indian city ?",
            "In which year NSE(National Stock exchange) established ?",
            "Which Indian Private sector bank first issued Contact less debt and Credit cards ?",
            "MTS is largest mobile operator in which country ?",
            "Coca-Cola head quarters is located at which city ?",
            "Which e-Commerce company acquired Fashion brand and online store Myntra ?",
            "\"The name you can bank upon\" is the tagline of which Indian Public sector bank tagline ?",
            "Full form of TCS is ?",
            "What products Pepperfry.com sells online ?",
            "Unique in diversity is Which country tourism tagline ?",
            "What is the name of Hong Kong Stock Market Index ?",
            "HSBC is a \"Banking Corporation.\" What does the HS stand for?",
            "In 2000, Olay dropped what two words from its brand name?",
            "What is the full form of IBM ?",
            "Search Engine Bing is owned by ?",
            "In which year Yes bank was founded ?",
            "Indian Conglomerate ITC head quarters is located in which Indian city ?",
            //ECONOMICS
            "Who is the father of Economics ?",
            "Indian Economy is :",
            "\"An Enquiry into the Nature and Causes of Wealth of Nations\" is the book of economist-",
            "Who has given scarcity definition of economics ?",
            "Which theory is generally included under micro economics ?",
            "Whose opinions have revolutionised the scope of macro economics ?",
            "Passive factor of production is ",
            "Under law of demand ",
            "For inferior commodities, income effect is",
            "When total utility becomes maximum, then marginal utility will be",
            "Utility means ",
            "Marginal utility is equal to average utility at that time when average utility is",
            "At point of satiety, marginal utility is",
            "Which of the following is the second law of Gossen?",
            "Total utility of a commodity is measured by which price of that commodity ?",
            "According to Marshall, the basis of consumer surplus is",
            "In investment management, what does the acronym ETF stand for?",
            "In finance, what does M&A commonly stand for?",
            "Who is the chairman of Planning Commission of India?",
            "According to Modern Theory of Rent, rent accrues to ",
            //CURRENCY
            "What is the national currency of Afghanistan?", "What is the national currency of Albania?",
            " What is the national currency of Algeria?","What is the national currency of Andorra?",
            " What is the national currency of Angola?"," What is the national currency of Antigua and Barbuda?",
            " What is the national currency of Argentina?"," What is the national currency of Armenia?",
            " What is the national currency of Australia?"," What is the national currency of Austria?",
            " What is the national currency of Azerbaijan?"," What is the national currency of The Bahamas?",
            " What is the national currency of Bahrain?"," What is the national currency of Bangladesh?",
            " What is the national currency of Barbados?"," What is the national currency of Vatican City?",
            " What is the national currency of Yemen?"," What is the national currency of Morocco?",
            " What is the national currency of Nepal?"," What is the national currency of Netherlands?",
            " What is the national currency of New Zealand?"," What is the national currency of Germany?",
            //WORLD CAPITALS
            "Cairo is the capital of which country?","Zagreb is the capital of which country?","Tbilisi is the capital of which country?","Santiago is the capital of which country?","Tehran is the capital of which country?","Buenos Aires is the capital of which country?","New Delhi is the capital of which country?","Pyongyang is the capital of which country?","Kabul is the capital of which country?",
            "Reykjavik is the capital of which country?","Canberra is the capital of which country?","Port-au-Prince is the capital of which country?","Copenhagen is the capital of which country?","Helsinki is the capital of which country?","Tallinn is the capital of which country?",
            "Kathmandu is the capital of which country?","Beirut is the capital of which country?","Ankara is the capital of which country?","Lima is the capital of which country?","Mogadishu is the capital of which country?","Bucharest is the capital of which country?",
            "Warsow is the capital of which country?","Colombo is the capital of which country?",
            //WORLD MOUNTAINS
            "Mauna Kea is in which country/countries?","Ben Nevis is in which country/countries?","Mont Blanc is in which country/countries?","Vinson Massif is on which continent?","Aconcagua is in which country/countries?","Kilimanjaro is a mountain in which country/countries?",
            "K2 is a mighty mountain in which country/countries?","Mount Everest is in which country/countries?","The mountain Annapurna is in which country/countries?","Mount McKinley is in which country/countries?","Table Mountain is in which country/countries?","Kailas is on which continent?",
            "Bishorn is in which country/countries?","Mount Logan - Yukon is in which country/countries?","Shishapangma is in which country/countries?",
            //WORLDS LAKES
            "The Caspian Sea is NOT neighboured by which of the countries?","Michigan-Huron lake is between these countries?","Lake Victoria is NOT neighboured by this country?","Lake Baikal is the deepest lake in the world. In which country is it?",
            "The Great Bear Lake is in which country?","The Great Slave Lake is in which country?","Ladoga is the largest lake in Europe. In which country is this?","Titicaca is one of the highest lakes in the world. Which country does neighbour it?","In which country is Vanern?",
            "Winnipegosis is a lake in which country?","Great Salt Lake is in which country?","Qinghai Lake is the largest lake in East Asia. In which country is it?",
            "Saimaa is a large lake with numerous basins and 14,000 islands. Where is this?","Lake of the Woods is neighboured by these countries.","Khanka is a lake on which continent?",
            //ARITHMETIC APTITUDE
            "A person crosses a 600 m long street in 5 minutes. What is his speed in km per hour?","An aeroplane covers a certain distance at a speed of 240 kmph in 5 hours. To cover the same distance in 1 2/3 hours, it must travel at a speed of:",
            "If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more. The actual distance travelled by him is: ","A train can travel 50% faster than a car. Both start from point A at the same time and reach point B 75 kms away from A at the same time. On the way, however, the train lost about 12.5 minutes while stopping at the stations. The speed of the car is:",
            "Excluding stoppages, the speed of a bus is 54 kmph and including stoppages, it is 45 kmph. For how many minutes does the bus stop per hour?",
            "In a flight of 600 km, an aircraft was slowed down due to bad weather. Its average speed for the trip was reduced by 200 km/hr and the time of flight increased by 30 minutes. The duration of the flight is: ",
            "A man complete a journey in 10 hours. He travels first half of the journey at the rate of 21 km/hr and second half at the rate of 24 km/hr. Find the total journey in km.",
            "The ratio between the speeds of two trains is 7 : 8. If the second train runs 400 kms in 4 hours, then the speed of the first train is: ",
            "A man on tour travels first 160 km at 64 km/hr and the next 160 km at 80 km/hr. The average speed for the first 320 km of the tour is:",
            "A car travelling with 5/7 of its actual speed covers 42 km in 1 hr 40 min 48 sec. Find the actual speed of the car.",
            "In covering a distance of 30 km, Celine takes 2 hours more than Sam. If Celine doubles his speed, then he would take 1 hour less than Sam. Speed of Celine is: ",
            "Robert is travelling on his cycle and has calculated to reach point A at 2 P.M. if he travels at 10 kmph, he will reach there at 12 noon if he travels at 15 kmph. At what speed must he travel to reach A at 1 P.M.? ",
            "It takes eight hours for a 600 km journey, if 120 km is done by train and the rest by car. It takes 20 minutes more, if 200 km is done by train and the rest by car. The ratio of the speed of the train to that of the cars is: ",
            "A farmer travelled a distance of 61 km in 9 hours. He travelled partly on foot @ 4 km/hr and partly on bicycle @ 9 km/hr. The distance travelled on foot is: ",
            "A and B together have Sterling 1210. If 4/15 of amount of A is equal to 2/5 of amount of B, how much amount does B have? ",
            "Two numbers are respectively 20% and 50% more than a third number. The ratio of the two numbers is: ","A sum of money is to be distributed among A, B, C, D in the proportion of 5 : 2 : 4 : 3. If C gets Euro 1000 more than D, what is share of B?",
            "Seats for Mathematics, Physics and Biology in a school are in the ratio 5 : 7 : 8. There is a proposal to increase these seats by 40%, 50% and 75% respectively. What will be the ratio of increased seats? ","In a mixture 60 litres, the ratio of milk and water 2 : 1. If the this ratio is to be 1 : 2, then the quanity of water to be further added is: ",
            "The ratio of the number of boys and girls in a college is 7 : 8. If the percentage increase in the number of boys and girls be 20% and 10% respectively, what will be the new ratio? ","If 0.75 : x :: 5 : 8, then x is equal to:",
            //PERCENTAGE
            "Two students appeared at an examination. One of them secured 9 marks more than the other and his marks was 56% of the sum of their marks. The marks obtained by them are: ","A fruit seller had some apples. He sells 40% apples and still has 420 apples. Originally, he had:","What percentage of numbers from 1 to 70 have 1 or 9 in the units digit?","If A = x% of y and B = y% of x, then which of the following is true?","In a certain school, 20% of students are below 8 years of age. The number of students above 8 years of age is 2/3 of the number of students of 8 years of age which is 48. What is the total number of students in the school?","A student multiplied a number by 3/5 instead of 5/3. What is the percentage error in the calculation?","In an election between two candidates, one got 55% of the total valid votes, 20% of the votes were invalid. If the total number of votes was 7500, the number of valid votes that the other candidate got, was: ","Three candidates contested an election and received 1136, 7636 and 11628 votes respectively. What percentage of the total votes did the winning candidate get? ","Helen went to the stationers and bought things worth Euro 25, out of which 30 paise went on sales tax on taxable purchases. If the tax rate was 6%, then what was the cost of the tax free items?","The population of a town increased from 1,75,000 to 2,62,500 in a decade. The average percent increase of population per year is: ",
            //SERIES
            "Look at this series: 2, 1, (1/2), (1/4), ... What number should come next?","Look at this series: 7, 10, 8, 11, 9, 12, ... What number should come next?","Look at this series: 36, 34, 30, 28, 24, ... What number should come next?","Look at this series: 22, 21, 23, 22, 24, 23, ... What number should come next?","Look at this series: 53, 53, 40, 40, 27, 27, ... What number should come next?","Look at this series: 21, 9, 21, 11, 21, 13, 21, ... What number should come next?","Look at this series: 58, 52, 46, 40, 34, ... What number should come next?","Look at this series: 3, 4, 7, 8, 11, 12, ... What number should come next?","Look at this series: 8, 22, 8, 28, 8, ... What number should come next?","Look at this series: 31, 29, 24, 22, 17, ... What number should come next?","Look at this series: 1.5, 2.3, 3.1, 3.9, ... What number should come next?","Look at this series: 14, 28, 20, 40, 32, 64, ... What number should come next?","Look at this series: 2, 4, 6, 8, 10, ... What number should come next?","Look at this series: 201, 202, 204, 207, ... What number should come next?","Look at this series: 544, 509, 474, 439, ... What number should come next?","Look at this series: 80, 10, 70, 15, 60, ... What number should come next?","Look at this series: 2, 6, 18, 54, ... What number should come next?","Look at this series: 1000, 200, 40, ... What number should come next?",
            //SYNONYMS
            "What is the synonym for ERRORNEOUS","What is the synonym for SEIZE","What is the synonym for FABLE","What is the synonym for DASH","What is the synonym for PREDICAMENT","What is the synonym for ALLOTMENT","What is the synonym for NEAT","What is the synonym for MOODY","What is the synonym for OGLE","What is the synonym for INDOLENT","What is the synonym for ENGAGING","What is the synonym for NOTION","What is the synonym for SHROUD","What is the synonym for BUSTLE","What is the synonym for ESTEEM","What is the synonym for INAUGRATE","What is the synonym for RAVISHING","What is the synonym for WICKED","What is the synonym for INFURIATE","What is the synonym for ANSWER",
            //ANTONYMS
            "The antonym for ENORMOUS","The antonym for COMMISSIONED","The antonym for ARTIFICIAL","The antonym for EXODUS","The antonym for RELINQUISH","The antonym for EXPAND","The antonym for MORTAL","The antonym for QUIESCENT","The antonym for OBEYING","The antonym for FRADULENT","The antonym for FLAGITIOUS","The antonym for BELITTLE","The antonym for STARTLED","The antonym for BUSY","The antonym for FRESH","The antonym for CULPABLE","The antonym for RELUCTANT","The antonym for RESIST","The antonym for SUPERFLUOUS","The antonym for INCESSANT","The antonym for EXODUS",
            //SPELLINGS
            "Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.","Find the correctly spelt word.",
            //ANALOGIES
            "Odometer is to mileage as compass is to","Marathon is to race as hibernation is to","Window is to pane as book is to","Cup is to coffee as bowl is to","Yard is to inch as quart is to","Elated is to despondent as enlightened is to","Optimist is to cheerful as pessimist is to","Reptile is to lizard as flower is to","Play is to actor as concert is to","Sponge is to porous as rubber is to","Careful is to cautious as boastful is to","Pen is to poet as needle is to","Secretly is to openly as silently is to","Embarrassed is to humiliated as frightened is to","Pride is to lion as shoal is to",
            //CLASSIFICATION
            "Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.","Choose the word which is different from the rest.",
            //VERBAL CLASSIFICATION
            "Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?","Which word does NOT belong with the others?",
            //FOOD
            "The word coconut comes from a 16th century Portuguese word cocos meaning ?","In which year was Ben & Jerry ice cream company established?","Up until about 400 years ago the majority of carrots eaten in Europe were ____ in color?","A tomato is a _____ ?","A calzone (sounds like kal-zone-ay) is a type of ?","A dried plum is properly known as a _____ ?","Strawberries, raspberries, peaches and cherries are all related to which type of flower?","The odd coloured fruits from a plant whose latin name is Musa Velutina are ____ ?","The first breakfast cereal (invented in 1863) was not popular because ?","From which country do potatoes originate?"
    };
    String a[]={
            // INTERNATIONAL BRANDS
            "ConAgra","Italy","1974","$625","Leo","Henry Ford","Pink","VISA","It is the Real Thing","L Oreal","Nestle Crunch",
            "Alfa-Romeo","Sweet Tarts","NASA","Wal-Mart","Australia","Hanuta","AOL","NetFlix","Embraer","Rochefort","New York","IBM",
            //INDIAN BRANDS
            "P & G","Jam","Parle","Poppins","Fanta","Soap","Godrej","Kotak Mahindra Bank","Johnsonís baby shampoo","P & G","Cipla","Fruit Juice",
            "Britannia","Soft drink","Jaypee Group","Base Corporation","Toshiba","Vinod Khanna","Pepsico",
            //BUSINESS
            "Indian State Bank","Pepsi","Glen Mc Wrath","Hindustan Chip Limited","Kolkata","Cyrus P Mistry","Associated Cement Companies","Kolkata","1994",
            "ICICI Bank","Canada","Greece","SnapDeal","Bank of Maharashtra","Tata Consultancy Services","Spices","Belgium","Hengsans","High Strategy","Reduction of",
            "International Business Machines","Yahoo","2006","Bengaluru",
            //ECONOMICS
            "Max Muller","Socialistic Economy","Max Muller","Max Muller","Price Theory","Adam Smith","Only land","Price of commodity is an independent variable",
            "Zero","Minimum","Power to satisfy a want","Increasing","Zero","Law of equi-marginal utility","Value in use","Law of diminishing marginal utility",
            "External Total For","Multi-currency & Activation","President","Any factor",
            //CURRENCY
            "Afghan afghani", "Sloty", "Dram", "Euro", "Angolan kwanzarial","US Dollar"," Argentine manat", "Armenian ruble", "Australian pound",
            "Austrian sloty","Azerbaijani florin","Bahamian dollar","Bahraini rupee","Bangladeshi taka"," Barbadian dollar"," Vatican City Liira",
            " Yemeni dirham"," Moroccan rand","Nepalese rupee","Krone","New Zealand dollar" ,"Euro",
            //WORLD CAPITALS
            "Georgia","Croatia","Georgia","Croatia","Iraq","Bermuda","India","South Korea","Andorra","Jamaica","Austria","Honduras","Norway",
            "France","Equador","Peru","Lebanon","Uruguay","Nicaragua","Tanzania","Bulgaria","Poland","Taiwan",
            //WORLD MOUNTAINS
            "United States","Scotland/U K","France-Germany","Europe","Mexico","Nepal","Nepal","Nepal-China","Japan","Philippines","Morocco",
            "Asia","Austria alone","United States","Russia",
            //WORLDS LAKES
            "Kazakhstan","Canada-United States","Uganda","Canada","Canada","Kazakhstan","France","Peru","Finland","Canada","United States",
            "Malaysia","Finland","Canada-United States","North America",
            //ARITHMETIC APTITUDE
            "3.6","300kmph","50km","100kmph","9","1 hour","220 km","70 km/hr","35.55 km/hr","17 6/7 km/hr","5 kmph","8 kmph","2 : 3","14 km",
            "Sterling 460","2 : 5","Euro 500","2 : 3 : 4","20 litres","8 : 9","1.12",
            //PERCENTAGE
            "39, 30","588 apples","1","A is smaller than B","80","34%","2700","57%","Euro 15","4.37%",
            //SERIES
            "(1/3)","7","20","22","12","14","26","7","9","15","4.2","52","11","205","404","20","108","8",
            //SYNONYMS
            "Enormous","Start","Story","Crawl","Truthful","Quantity","Portion","Skirmish","Parental","Lazy","Married","Scribble","Clean","Body","Rule","Launch","Hungry","Good","Influx","Stout",
            //ANTONYMS
            "Soft","Started","Red","Influx","Abdicate","Convert","Divine","Active","Ordering","Candid","Innocent","Criticize","Amused","Occupied","Faulty","Defendable","wanting","fight","important","intermittent","invasion",
            //SPELLINGS
            "Efficient","Foreign","Ommineous","Pessenger","Benefitted","Treachrous","Forcast","Rigerous","Palete","Bouquete","Vetarinary","Chancelary","Excessive","Indipensable","Humorous",
            //ANALOGIES
            "speed","winter","novel","dish","gallon","aware","gloomy","petal","symphony","massive","arrogant","thread","scarcely","terrified","teacher",
            //CLASSIFICATION
            "Chicken","Cap","Kiwi","Curd","Potassium","Tea","Hangar","Sparrow","Tall","Pear","Dagger","Deck","Producer","Tricycle","Chameleon",
            //VERBAL CLASSIFICATION
            "parsley","inch","tyre","tulip","rye","guitar","dodge","branch","street","heading","tape","leopard","couch","cornea","noun","book","unimportant",
            //FOOD
            "angry face","1958","White","Fruit","Potato","Prune","Rose","pink bananas","it was green","Ireland"
    };
    String b[]={
            // INTERNATIONAL BRANDS
            "General Mills","Germany","1976","$6,250","Larry","Charles Rolls","Green","Discover","Coca-Cola..Real","Revlon","Twix",
            "Infiniti","Smarties","Audi","Kmart","United States","Milka","Google","Rakuten","Airbus","Leffe","Detroit","Tata",
            //INDIAN BRANDS
            "Hindustan Unilever", "Noodles","ITC","KrackJack","Sprite","Shampoo","Procter & Gamble","ICICI Bank","Dove shampoo","Dabur","P & G",
            "Tooth Paste","Parle","Nail polish","Tata Group","Hindustan Unilever","Sony","Salman Khan","Dabur",
            // BUSINESS
            "State Bank of Hindustan","Coca-Cola","Brett Lee","Hindustan Computer Limited","Ahmedabad","N Chandrasekaran","Association of Cement Companies","Chennai","1988",
            "HDFC Bank","England","Canada","FlipKart","Vijaya Bank","Tata Corporate Services","Food","Bulgaria","HKI","Holmes and Stevenson","Oil of",
            "International Business Models","Microsoft","2000","Mumbai",
            // ECONOMICS
            "Adam Smith","Gandhian Economy","Adam Smith","Adam Smith","Income Theory","J.B. Say","Only capital","Quantity demanded is a dependent variable",
            "Negative","Average","Usefulness","Maximum","Positive","Law of equi-product","Value in exchange","Law of equi-marginal utility",
            "Excellent Travel Fund","Maintenance & Advice","Vice President","Capital only",
            //CURRENCY
            "Afghani rupiya", "Lek" , "Algerian Dollar", "Andorran Dollar", "Angolan peso", "Caribbean Peso"," Argentine pound",
            "Armenian dollar","Australian dollar", "Austrian dollar", "Azerbaijani dram", "Bahamian pound", "Bahraini dinar", "Bangladeshi rupee",
            " Barbadian peseta"," Vatican City Peso"," Yemeni franc"," Moroccan dollar", "Nepalese dollar","Liire"," New Zealand rupee",
            "Deutsche Mark",
            //WORLD CAPITALS
            "Haiti","Costa Rica","Gabon","Cuba","Iran","Bolivia","New Guyana","North Korea","Ukraine","Jordan","Australia","Haiti",
            "Denmark","Honduras","Czech Republic","Oman","Latvia","Turkey","Peru","Senegal","Romania","Czech Republic","Tanzania",
            //WORLD MOUNTAINS
            "Japan","Canada","Italy-France","Antarcitica","Canada","Tanzania","India","China-India","India","United States","South-Africa","South-America",
            "Switzerland alone","Russia","Turkey",
            //WORLDS LAKES
            "Russia","Mexico-United States","Kenya","Hungary","United States","Russia","Poland","Kenya","Sweden","United States",
            "Canada","China","Iceland","Russia-China","Asia",
            //ARITHMETIC APTITUDE
            "7.2","30kmph","56km","110kmph","10","2 hours","224 km","75 km/hr","36 km/hr","25 km/hr","6 kmph","11 kmph","3 : 2","15 km","Sterling 484",
            "3 : 5","Euro 1500","6 : 7 : 8","30 litres","17 : 18","1.2",
            //PERCENTAGE
            "41, 32","600 apples","14","A is greater than B","100","44%","2900","60%","Euro 15.7","5%",
            //SERIES
            "(1/8)","10","22","24","14","15","28","10","29","14","4.4","56","12","208","414","25","148","10",
            //SYNONYMS
            "Wrong","Release","Weak","Ball","Easy","Everything","Almost","Position","Seaming","Urgent","Spellbinding","Marks","Clothing","Break","Remarkable","Invest","Ripped","Bad","Enrage","Retort",
            //ANTONYMS
            "Average","Closed","Natural","Home-coming","Renounce","Condense","Immortal","Dormant","Following","Direct","Vapid","Flatter","Relaxed","Engrossed","Sluggish","Blameless","willing","accept","relevant","harsh","entry",
            //SPELLINGS
            "Treatmeant","Foreine","Omineous","Passenger","Benifited","Trecherous","Forecaste","Rigourous","Palet","Bouquette","Veteninary","Chancellery","Exccessive","Indipenseble","Ganerous",
            //ANALOGIES
            "hiking","bear","glass","soup","ounce","ignorant","mean","stem","musician","solid","humble","button","impolitely","agitated","student",
            //CLASSIFICATION
            "Snake","Turban","Eagle","Butter","Silicon","Cinchona","Platform","Swan","Huge","Apple","Hammer","Quay","Director","Trident","Crocodile",
            //VERBAL CLASSIFICATION
            "basil","ounce","steering wheel","rose","sourdough","flute","flee","dirt","freeway","body","twine","cougar","rug","retina","preposition","index","trivial",
            //FOOD
            "weeping face","1978","Red","Vegetable","Peach","Raisin","Lily","pink oranges","it was very expensive","South America"
    };
    String c[]={
            // INTERNATIONAL BRANDS
            "Kraft Heinz","United States","1978","$62,500","Lou","Karl Benz","Orange","American Express","Coke. Really the best","Cover Girl","Milky Way",
            "BMW","Pop Rocks","Lucky Strike","Target","Italy","Kinder","Yahoo","eBay","Boeing","Chimay","Las Vegas","Virgin",
            //INDIAN BRANDS
            "Godrej","Health Drink","Hindustan Unilever","Mango Bite","Slice","Hair color","ITC","South Indian Bank","Himalaya baby shampoo","Nirma","Ranbaxy","Hair color",
            "ITC","Toilet soap","ITC Group","P & G","Microsoft","Akshay Kumar","Hindustan Unilever",
            //BUSINESS
            "Imperial Bank of India","Thumbs Up","Michael Clark","Hindustan Corporation Limited","Mumbai","Ratan Tata","Associated Cementrics Corporation","Mumbai","1990",
            "Bank Of Baroda","Russia","Greenland","eBay","Axis Bank","Tata Consulting Services","Furniture","Bermuda","HKS","Housing & Securities","Tincture of",
            "International Biometric Machines","Google","2002","Kolkata",
            //ECONOMICS
            "Karl Marx","Mixed Economy","Karl Marx","Karl Marx","Employment Theory","J.M. Keynes","Both land & capital","Reciprocal relationship is found between price and quantity demanded",
            "Infinite","Zero","Willingness of a person","Falling","Maximum","Theory of indifference curve","Both of above","Law of proportions",
            "Existing Trade Fund","Money & Action","Prime Minister","Land only",
            //CURRENCY
            "Afghan Dollar", "Kwanza", "Algerian Dinar", "Andorran Sekel", "Angolan pound", "East Caribbean Dollar"," Argentine peso",
            "Armenian sole", "Australian euro","Euro","Azerbaijani manat", "Bahamian peso", "Bahraini peseta", "Bangladeshi renmin", " Barbadian franc",
            "Euro"," Yemeni rial"," Moroccan liire", "Nepalese tugarg","Euro"," New Zealand pound","German Mark",
            //WORLD CAPITALS
            "Iceland","Estonia","Guatemala","Congo","Kenya","Argentina","Kuwait","Kazakhstan","Afghanistan","Iceland","Angola","Hungary","Netherlands","Finland",
            "Estonia","Qatar","Maldives","Uganda","Panama","Kenya","Hungary","Samoa","Sri Lanka",
            //WORLD MOUNTAINS
            "Philippines","Norway","Austria alone","Australia","Argentina","Somalia","Pakistan-China","Pakistan","Nepal","Canada","Algeria","North-America",
            "Germany","Georgia","Romania",
            //WORLDS LAKES
            "Turkey","Cuba-United States","Tanzania","Russia","Russia","Canada","Germany","Nicaragua","Norway","Russia","Israel","Indonesia",
            "Italy","United States-Mexico","Australia",
            //ARITHMETIC APTITUDE
            "8.4","600kmph","70km","120kmph","12","3 hours","230 km","84 km/hr","71.11 km/hr","30 km/hr","6.25 kmph","12 kmph","3 : 4","16 km",
            "Sterling 550","4 : 5","Euro 2000","6 : 8 : 9","40 litres","21 : 22","1.25",
            //PERCENTAGE
            "42,33","688 apples","20","If x is smaller than y, then A is greater than B.","120","54%","3000","65%","Euro 19.7","6%",
            //SERIES
            "(2/8)","12","23","25","27","21","30","14","32","13","4.7","96","13","210","420","30","162","15",
            //SYNONYMS
            "Eraded","Length","Truthful","Eye-brow","Quandary","Share","Negative","Sullen","Gaze","Menacing","Boring","Thought","Messy","Return","Cherish","Graduate","Pretty","Weird","Engage","Putrid",
            //ANTONYMS
            "Tiny","Finished","Truthful","Return","Possess","Congest","Spiritual","Weak","Refusing","Forthright","Ignorant","Exaggerate","Endless","Relaxed","Disgraceful","Careless","anxious","welcome","significant","soft","immigration",
            //SPELLINGS
            "Reterment","Fariegn","Ominous","Pasanger","Benefited","Trechearous","Forcaust","Regorous","Palate","Bouquet","Vetinary","Chancelery","Exxcesive","Indispansible","Pupolous",
            //ANALOGIES
            "needle","dream","cover","spoon","milk","miserable","petty","daisy","piano","elastic","joyful","sewing","noisily","courageous","self-respect",
            //CLASSIFICATION
            "Swan","Helmet","Emu","Oil","Zirconium","Rubber","Dock","Parrot","Thin","Orange","Knife","Stern","Investor","Trifle","Alligator",
            //VERBAL CLASSIFICATION
            "dill","centimeter","engine","bud","pumpernickel","violin","duck","leaf","interstate","letter","cord","elephant","table","pupil","punctuation","glossary","insignificant",
            //FOOD
            "grinning face","1988","Orange","Herb","Pizza","Date","Daffodil","pink pineapples","it had to be soaked overnight","Greenland"

    };
    String d[]={
            // INTERNATIONAL BRANDS
            "Kellogs","United Kingdom","1980","$625,000","Luke","Gottlieb Daimler","Yellow","Master Card","Make It Real","Maybelline","Kit Kat",
            "Lexus","Twizzlers","Word Press","CVS","France","Manner","Ask Jeeves","Amazon","Tupolev","Kronenbourg","Dallas","EMI",
            //INDIAN BRANDS
            "ITC","Chocolate","Britannia","All of these","Mountain Dew","Liquid Blue","Nirma","Axis Bank","Garnier shampoo","Hindustan Unilever","Johnson","Shampoo","Patanjali",
            "Hair color","Reliance group","Exide","Samsung","Shahrukh Khan","ITC",
            // BUSINESS
            "Indian Imperial Bank","Red Bull","Adam Gilchrist","Hindustani Computer Limited","Bengaluru","None of above","None of above","Bengaluru","1992",
            "Axis Bank","Japan","Atlanta","Koovs","Punjab National Bank","Tokyo Consulting Services","Electronics","Britain","Hangseng","HongKong & Shanghai","Aroma of",
            "Indian Business Machines","Orkut","2004","Chennai",
            // ECONOMICS
            "None of these above","Free Economy","None of these above","Robbins","None of these above","All of the above","Neither land nor capital","All of the above",
            "Positive","Negative","Harmfulness","Minimum","Negative","Law of diminishing marginal utility","None of above","All of the above",
            "Exchange Traded Fund","Mergers & Acquisitions","Finance Minister","Labour only",
            //CURRENCY
            "Afghan yen", "Ruble", "Taka", "Andorran Pound", "Angolan kwanza", "Karbo", "Argentine dollar","Armenian dram","Australian renmin",
            "Austrian dinar", "Azerbaijani ruble", "Bahamian pestas", "Bahraini pula", "Bangladeshi dollar", " Barbadian pound","Swiss Franc"," Yemeni dinar",
            " Moroccan dirham", "Nepalese yuan","Franc","Australian Dollar" ,"German Franc",
            //WORLD CAPITALS
            "Egypt","Fiji","Indonesia","Chile","Kosovo","Armenia","Kygyyztan","Hungary","Azerbaijan","Ireland","Andorra","Eritrea","Latvia","Georgia","Lithuania",
            "Nepal","Malta","Vanuatu","Paraguay","Somalia","Montenegro","San Marino","Slovakia",
            //WORLD MOUNTAINS
            "Indonesia","Holland","Switzerland alone","North America","Peru","South-Africa","Japan","Bangladesh","Indonesia","Venezuela","Kenya",
            "Antarcitica","Poland","Canada","China",
            //WORLDS LAKES
            "Iran","Russia-China","Democratic Republic of the Congo","Mongolia","South Africa","Ivory Coast","Russia","Democratic Republic of the Congo",
            "Greenland","Kazakhstan","Iran","Philippines","Singapore","Mongolia-China","Europe",
            //ARITHMETIC APTITUDE
            "10","720kmph","80km","130kmph","20","4 hours","234 km","87.5 km/hr","71 km/hr","35 km/hr","7.5 kmph","14 kmph","4 : 3","17 km","Sterling 664",
            "6 : 7","Euro 1000","3 : 5 : 4","60 litres","Cannot be determined","1.30",
            //PERCENTAGE
            "43,34","700 apples","21","None of these","60","64%","3100","90%","Euro 20","8.75%",
            //SERIES
            "(1/16)","13","26","26","53","23","32","15","34","12","5.1","128","14","211","445","50","216","20",
            //SYNONYMS
            "Weak","Grasp","Plant","Hurry","Denial","Discussion","Dapper","Advise","Leach","Active","Understanding","Slay","Conceal","Hurry","Menacing","Readiness","Odd","Strange","Manage","Mettlesome",
            //ANTONYMS
            "Weak","Terminated","Solid","Restoration","Deny","Conclude","Eternal","Unconcerned","Contradicting","Genuine","Frivolous","Adore","Astonished","Engaged","Stale","Irresponsible","eager","repel","essential","constant","expulsion",
            //SPELLINGS
            "Employd","Forein","Omenous","pesanger","Benefeted","Treacherous","Forecast","Rigorous","Pelate","Boqquet","Veterinary","Chancellary","Excesive","Indispensable","Maretorious",
            //ANALOGIES
            "direction","sleep","page","food","liquid","tolerant","helpful","alligator","percussion","inflexible","suspicious","tailor","quietly","reckless","fish",
            //CLASSIFICATION
            "Crocodile","Veil","Ostrich","Cheese","Gallium","Chalk","Park","Koel","Sharp","Guava","Sword","Bow","Financier","Tricolour","Locust",
            //VERBAL CLASSIFICATION
            "mayonnaise","yard","car","daisy","loaf","cello","avoid","root","expressway","closing","yarn","lion","chair","vision","adverb","chapter","familiar",
            //FOOD
            "None of the above","1998","Green","None of the above","Cake","Fig","Tulip","pink mango","it was not tasty","Ethiopia",
    };
    int ans[]={
            // INTERNATIONAL BRANDS(1-23)
            1,3,2,4,2,1,4,1,3,1,4,1,4,2,3,3,3,3,3,2,4,2,3,
            //INDIAN BRANDS(24-42)
            2,1,4,4,3,4,2,1,1,2,2,2,2,4,2,3,3,4,4,
            //BUSINESS(43-66)
            3,1,3,2,4,2,1,2,4,1,3,4,2,4,1,3,2,4,4,2,1,2,4,3,
            //ECONOMICS(67-86)
            2,3,2,4,1,3,3,4,2,3,1,2,1,1,1,1,4,4,3,1,
            //CURRENCY(87-108)
            1,2,3,1,4,3,3,4,2,3,3,1,2,1,1,3,3,4,1,3,1,2,
            //WORLD CAPITALS(109-130)
            4,1,1,4,2,3,1,2,3,3,2,2,2,3,3,4,1,2,2,4,2,1,3,
            //WORLD MOUNTAINS(131-147)
            1,1,2,2,3,2,3,1,3,2,2,1,2,4,4,
            //WORLDS LAKES(148-162)
            3,1,4,3,1,3,4,1,2,1,1,2,1,1,2,
            //ARITHMETIC APTITUDE(163-183)
            2,4,1,3,2,1,2,4,3,4,1,3,3,3,2,3,3,1,4,3,2,
            //PERCENTAGE(184-193)
            3,4,3,4,2,4,1,1,3,2,
            //SERIES(194-211)
            2,2,2,3,2,2,2,4,4,1,3,2,2,4,1,1,3,1,
            //SYNONYMS(212-231)
            2,4,1,4,3,3,4,3,3,1,2,3,4,4,3,1,3,2,2,2,
            //ANTONYMS(232-242)
            3,4,2,1,3,2,2,1,1,4,1,3,2,3,4,2,2,3,2,1,2,
            //SPELLINGS(243-257)
            1,1,3,2,3,4,4,4,3,3,4,2,1,4,1,
            //ANALOGIES(258-272)
            4,4,4,2,2,2,1,3,2,3,1,4,3,1,4,
            //CLASSIFICATION(273-287)
            1,4,2,3,1,4,4,2,4,3,2,2,2,3,4,
            //VERBAL CLASSIFICATION(288-304)
            4,2,4,3,1,2,2,2,1,3,1,3,2,4,3,1,4,
            //FOOD(305-314)
            3,2,1,1,3,1,1,1,3,2
    };

    public int id;
    String Username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start2);


        Log.d("db values","questions size: " + q.length + "option a size: " + a.length + " opb size: " + b.length + " opc size: " + c.length + " opd size: " + d.length + "ans size: " + ans.length);
        Intent gotIntent = getIntent();
        id  = gotIntent.getIntExtra("id",0);
        Username = getIntent().getStringExtra("nameA");
        // the position of the maintopic and subtopic selected by the user.
        // Make your database using this baby :) Love you too :p
        int MainTopicPosition = gotIntent.getIntExtra("MainTopicposition",0);
        int SubTopicPosition = gotIntent.getIntExtra("SubListposition",0);
        //flag = gotIntent.getBooleanExtra("Replay",true);
        //Bundle data=getIntent().getExtras();
        //n=data.getString("Name");
        createDatabase();

        p=db.rawQuery("SELECT * FROM questions", null);
        if(!p.moveToFirst())
            insertDB();

        Log.d("\n db values","questions size: " + q.length + "option a size: " + a.length + " opb size: " + b.length + " opc size: " + c.length + " opd size: " + d.length + "ans size: " + ans.length);
        howToplay = (TextView) findViewById(R.id.howtoplay);
        highscore = (TextView) findViewById(R.id.highscore);
        gameStart = (TextView) findViewById(R.id.startquiz);

        gameStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(getApplicationContext(), QuizActivity.class);
                i.putExtra("id", id);
                i.putExtra("name",Username);
                startActivity(i);
            }
        });
        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameStartActivity.this,HighScoreBoard.class);
                startActivity(i);
            }
        });
        howToplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameStartActivity.this,HowToPlay.class);
                startActivity(i);
            }
        });

    }
    protected void createDatabase()
    {
        db=openOrCreateDatabase("QuizDB.db", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS questions(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, question VARCHAR, opA VARCHAR," +
                "opB VARCHAR, opC VARCHAR,opD VARCHAR,answer NUMBER)");
    }
    protected void insertDB()
    {
        //tv.setText("Getting the quiz ready...");
        int l = 323;
        for(int i=0 ;i<l; i++)
        {
            String query="INSERT INTO questions(question,opA,opB,opC,opD,answer) values('"+q[i]+"','"+a[i]+"','"+b[i]+
                    "','"+c[i]+"','"+d[i]+"','"+ans[i]+"');)";
            db.execSQL(query);
        }
        Toast.makeText(getApplicationContext(), "Application ready to use!", Toast.LENGTH_SHORT).show();
    }

    protected void openDatabase() {
        db = openOrCreateDatabase("QuizDB.db", Context.MODE_PRIVATE, null);
    }
}
