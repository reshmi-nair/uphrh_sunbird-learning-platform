package com.ilimi.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ekstep.language.router.LanguageRequestRouterPool;
import org.ekstep.searchindex.consumer.ConsumerRunner;

import com.ilimi.common.router.RequestRouterPool;


public class InitServlet extends HttpServlet {

    private static final long serialVersionUID = 8162107839763607722L;
    
    private static Logger LOGGER = LogManager.getLogger(InitServlet.class.getName());
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // Initialising Request Router Pool
        LOGGER.info("Initialising Request Router Pool");
        RequestRouterPool.getActorSystem();
        LanguageRequestRouterPool.init();
        ConsumerRunner.startConsumers();
        //TODO fix later
        ConsumerRunner.startConsumers(new String[]{"8"}, "word_count");
    }
}
