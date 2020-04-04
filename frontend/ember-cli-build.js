// eslint-disable-next-line eslint-comments/disable-enable-pair
/* eslint-disable global-require */

const EmberApp = require('ember-cli/lib/broccoli/ember-app');

const isProduction = EmberApp.env() === 'production';

const purgeCSS = {
    module: require('@fullhuman/postcss-purgecss'),
    options: {
        content: [
            // add extra paths here for components/controllers which include tailwind classes
            './app/index.html',
            './app/templates/**/*.hbs',
            './app/components/**/*.hbs'
        ],
        whitelistPatterns: [/ember-power-calendar/],
        defaultExtractor: (content) => content.match(/[A-Za-z0-9-_:/]+/g) || [],
    },
};

module.exports = function (defaults) {
    const app = new EmberApp(defaults, {
        postcssOptions: {
            compile: {
                extension: 'scss',
                enabled: true,
                parser: require('postcss-scss'),
                plugins: [
                    {
                        module: require('@csstools/postcss-sass'),
                    },
                    {
                        module: require('postcss-import'),
                        options: {
                            path: ['node_modules'],
                        },
                    },
                    require('tailwindcss')('./app/tailwind/config.js'),
                    ...isProduction ? [purgeCSS] : [],
                ],
            },
        },
        'ember-power-calendar-date-fns': {
            includeLocales: ['en-US', 'en-GB'],
        },
    });
    return app.toTree();
};
