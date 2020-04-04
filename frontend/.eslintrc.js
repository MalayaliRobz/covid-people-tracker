module.exports = {
    root: true,
    parser: '@typescript-eslint/parser',
    parserOptions: {
        ecmaVersion: 2018,
        sourceType: 'module',
        ecmaFeatures: {
            legacyDecorators: true,
        },
    },
    extends: [
        'eslint:recommended',
        'plugin:ember/recommended',
        '@centerforopenscience/eslint-config/ember',
    ],
    plugins: [
        '@typescript-eslint',
    ],
    env: {
        browser: true,
    },
    rules: {
        'ember/no-jquery': 'error',
        'no-dupe-class-members': 'off',
        'no-unused-vars': 'off',
        'no-undef': 'off',

        'import/export': 'off',
        'import/named': 'off',
        'import/no-unresolved': 'off',
    },
    overrides: [
    // node files
        {
            files: [
                '.eslintrc.js',
                '.template-lintrc.js',
                'ember-cli-build.js',
                'testem.js',
                'blueprints/*/index.js',
                'config/**/*.js',
                'lib/*/index.js',
                'server/**/*.js',
            ],
            parserOptions: {
                sourceType: 'script',
            },
            env: {
                browser: false,
                node: true,
            },
            plugins: ['node'],
            rules: {
                ...require('eslint-plugin-node').configs.recommended.rules, // add your custom rules and overrides for node files here

                // this can be removed once the following is fixed
                // https://github.com/mysticatea/eslint-plugin-node/issues/77
                'node/no-unpublished-require': 'off',
            },
        },
    ],
};
