package com.crbaldwin.osu_wrapper;

import com.crbaldwin.osu_wrapper.exceptions.OsuBeatmapException;
import com.crbaldwin.osu_wrapper.exceptions.OsuGamemodeException;
import com.crbaldwin.osu_wrapper.exceptions.OsuUserException;
import com.crbaldwin.osu_wrapper.util.API_Request;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;

public class Osu {

    private String key;

    enum OsuGameMode {
        OSU, TAIKO, CATCHTHEBEAT, MANIA
    }


    //319e7d936f399ab7663781d5bf19858fdc04b2a8
    public Osu(String API_KEY) {
        key = API_KEY;
    }

    //Default call, returns OsuPlayer for
    public OsuPlayer getPlayer(String username, OsuGameMode mode) throws IOException, OsuUserException, OsuGamemodeException, JSONException, OsuBeatmapException {
        OsuPlayer player = new OsuPlayer(username, mode, this);
        return player;
    }

    public OsuPlayer getPlayer(int user_id, OsuGameMode mode) throws OsuUserException, IOException, OsuGamemodeException, JSONException, OsuBeatmapException {
        OsuPlayer player = new OsuPlayer(user_id, mode, this);
        return player;
    }

    public OsuBeatmap getBeatmap(int beatmap_id) throws IOException, JSONException, OsuBeatmapException {
        OsuBeatmap beatmap = new OsuBeatmap(beatmap_id, this);
        return beatmap;
    }

    public OsuPlay parseOsuPlay(JSONObject play) throws IOException, OsuBeatmapException {
        OsuPlay osu_play = new OsuPlay(play, this);
        return osu_play;
    }

    public String getAPIKey() {
        return key;
    }

}