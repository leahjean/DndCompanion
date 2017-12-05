package edu.illinois.cs465.ddc;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

/**
 * Activity handles page for selecting a race
 */
public class RaceSelectActivity extends Activity implements View.OnClickListener {
    ImageButton nextRaceBtn, backRaceBtn;
    Button backPageBtn, nextPageBtn;
    WrapContentHeightViewPager portraitViewPager;
    TextView raceNameView;
    private static final Map<String, String> tooltipTexts = initTooltipTexts();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.race_class_select);

        initPageTitle();
        initButtons();
        initTooltipTexts();
        initPortraitViewPager();
        initRaceNameView();
        raceNameView = (TextView) findViewById(R.id.race_class_name);

        // Display initial tooltip
        new SimpleTooltip.Builder(getApplicationContext())
                        .anchorView(raceNameView)
                        .text("Welcome to character creation! Click here for more details about this race.")
                        .gravity(Gravity.TOP)
                        .build()
                        .show();
    }

    // Set the page title to be select race
    private void initPageTitle() {
        TextView pageTitle = (TextView) findViewById(R.id.race_class_header);
        pageTitle.setText("Select Race");
    }

    // Initialize button variables and button event listeners for each button on the page
    private void initButtons() {
        backRaceBtn = (ImageButton) findViewById(R.id.race_class_back_btn);
        backRaceBtn.setOnClickListener(this);

        nextRaceBtn = (ImageButton) findViewById(R.id.race_class_next_btn);
        nextRaceBtn.setOnClickListener(this);

        backPageBtn= (Button) findViewById(R.id.race_class_back_page_btn);
        backPageBtn.setOnClickListener(this);

        nextPageBtn= (Button) findViewById(R.id.race_class_next_page_btn);
        nextPageBtn.setOnClickListener(this);
    }

    private static Map<String, String> initTooltipTexts() {
        Map<String, String> tooltipTexts = new HashMap<>();
        tooltipTexts.put("Aarakocra", "Sequestered in high mountains atop tall trees, the aarakocra, sometimes called birdfolk, evoke fear and wonder.");
        tooltipTexts.put("Aasimar", "Aasimar are placed in the world to serve as guardians of law and good. Their patrons expect them to strike at evil, lead by example, and further the cause of justice.");
        tooltipTexts.put("Bugbear", "Bugbears feature in the nightmare tales of many races — great, hairy beasts that creep through the shadows as quiet as cats.");
        tooltipTexts.put("Dragonborn", "Dragonborn look very much like dragons standing erect in humanoid form, though they lack wings or a tail.");
        tooltipTexts.put("Dwarf", "Bold and hardy, dwarves are known as skilled warriors, miners, and workers of stone and metal.");
        tooltipTexts.put("Elf", "Elves are a magical people of otherworldly grace, living in the world but not entirely part of it.");
        tooltipTexts.put("Feral Tiefling", "To be greeted with stares and whispers, to suffer violence and insult on the street, to see mistrust and fear in every eye: this is the lot of the tiefling.");
        tooltipTexts.put("Firbolg", "Firbolg tribes cloister in remote forest strongholds, preferring to spend their days in quiet harmony with the woods. When provoked, firbolgs demonstrate formidable skills with weapons and druidic magic.");
        tooltipTexts.put("Genasi", "Genasi carry the power of the elemental planes of air, earth, fire, and water in their blood.");
        tooltipTexts.put("Gnome", "A gnome’s energy and enthusiasm for living shines through every inch of his or her tiny body.");
        tooltipTexts.put("Goblin", "Goblins occupy an uneasy place in a dangerous world, and they react by lashing out at any creatures they believe they can bully.");
        tooltipTexts.put("Goliath", "Strong and reclusive, every day brings a new challenge to a goliath.");
        tooltipTexts.put("Half elf", "Half-elves combine what some say are the best qualities of their elf and human parents.");
        tooltipTexts.put("Halfling", "The diminutive halflings survive in a world full of larger creatures by avoiding notice or, barring that, avoiding offense.");
        tooltipTexts.put("Half orc", "Half-orcs’ grayish pigmentation, sloping foreheads, jutting jaws, prominent teeth, and towering builds make their orcish heritage plain for all to see.");
        tooltipTexts.put("Hobgoblin", "War is the lifeblood of hobgoblins. Its glories are the dreams that inspire them. Its horrors don’t feature in their nightmares.");
        tooltipTexts.put("Human", "Humans are the most adaptable and ambitious people among the common races. Whatever drives them, humans are the innovators, the achievers, and the pioneers of the worlds.");
        tooltipTexts.put("Kenku", "Haunted by an ancient crime that robbed them of their wings, the kenku wander the world as vagabonds and burglars who live at the edge of human society.");
        tooltipTexts.put("Kobold", "Kobolds are typically timid and shy away from conflict, but they are dangerous and vicious if cornered.");
        tooltipTexts.put("Lizardfolk", "Lizardfolk possess an alien and inscrutable mindset, their desires and thoughts driven by a different set of basic principles than those of warm-blooded creatures.");
        tooltipTexts.put("Orc", "Orcs live a life that has no place for weakness, and every warrior must be strong enough to take what is needed by force.");
        tooltipTexts.put("Tabaxi", "Hailing from a strange and distant land, wandering tabaxi are catlike humanoids driven by curiosity to collect interesting artifacts, gather tales and stories, and lay eyes on all the world’s wonders.");
        tooltipTexts.put("Tiefling", "To be greeted with stares and whispers, to suffer violence and insult on the street, to see mistrust and fear in every eye: this is the lot of the tiefling.");
        tooltipTexts.put("Tortle", "What many tortles consider a simple life, others might call a life of adventure. They are nomad survivalists eager to explore the wilderness.");
        tooltipTexts.put("Triton", "Long-established guardians of the deep ocean floor, in recent years the noble tritons have become increasingly active in the world above.");
        tooltipTexts.put("Yuan ti pureblood", "The serpent creatures known as yuan-ti are all that remains of an ancient, decadent human empire.");
        return Collections.unmodifiableMap(tooltipTexts);
    }

    // Initialize view pager to allow for carousel of races and add page change listener
    private void initPortraitViewPager() {
        portraitViewPager = (WrapContentHeightViewPager) findViewById(R.id.race_class_portrait_view_pager);
        PortraitViewPageAdapter pageAdapter = new PortraitViewPageAdapter(this, "race");
        portraitViewPager.setAdapter(pageAdapter);

        portraitViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            public void onPageSelected(int position) {
                raceNameView.setText(getCurrentRace());
            }
        });
    }

    // Initialize text view displaying the current race
    private void initRaceNameView() {
        raceNameView = (TextView) findViewById(R.id.race_class_name);
        raceNameView.setText(getCurrentRace());
        raceNameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SimpleTooltip.Builder(getApplicationContext())
                        .anchorView(view)
                        .text(tooltipTexts.get(getCurrentRace()))
                        .gravity(Gravity.TOP)
                        .build()
                        .show();
            }
        });
    }



    // Get the current race name from the ViewPagerAdapter's list of filenames
    private String getCurrentRace() {
        PortraitViewPageAdapter portraitAdapter = (PortraitViewPageAdapter) portraitViewPager.getAdapter();
        List<String> filenames = portraitAdapter.getImageFilenames();

        int currPosition = portraitViewPager.getCurrentItem();
        String rawFilename = filenames.get(currPosition)
                .replace("race_", "")
                .replace("_", " ");
        return rawFilename.substring(0, 1).toUpperCase() + rawFilename.substring(1);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.race_class_back_btn: {
                CharacterCreateUtil.raceClassScrollPrevPortrait(portraitViewPager);
                break;
            }
            case R.id.race_class_next_btn: {
                CharacterCreateUtil.raceClassScrollNextPortrait(portraitViewPager);
                break;
            }
            case R.id.race_class_back_page_btn:
                this.finish();
                break;
            case R.id.race_class_next_page_btn:
                Intent intent = new Intent(this, ClassSelectActivity.class);
                intent.putExtra("Selected Race", getCurrentRace());
                startActivity(intent);
                break;
        }
    }
}
