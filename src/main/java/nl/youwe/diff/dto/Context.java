package nl.youwe.diff.dto;

/*
 * This file is part of the rest diff project.
 *
 * (c) Osman Üngür <osmanungur@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import org.hibernate.validator.constraints.NotBlank;

public class Context {

    @NotBlank
    private String original;

    @NotBlank
    private String revised;

    public Context() {
    }

    public String getOriginal() {
        return original;
    }

    public String getRevised() {
        return revised;
    }
}
