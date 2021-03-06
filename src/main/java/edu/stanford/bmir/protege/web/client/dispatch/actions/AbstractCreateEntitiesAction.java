package edu.stanford.bmir.protege.web.client.dispatch.actions;

import edu.stanford.bmir.protege.web.client.dispatch.AbstractHasProjectAction;
import edu.stanford.bmir.protege.web.shared.annotations.GwtSerializationConstructor;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 25/03/2013
 */
public abstract class AbstractCreateEntitiesAction<R extends AbstractCreateEntityResult<E>, E extends OWLEntity> extends AbstractHasProjectAction<R> {

    private String sourceText;

    public AbstractCreateEntitiesAction(@Nonnull ProjectId projectId,
                                        @Nonnull String sourceText) {
        super(projectId);
        this.sourceText = checkNotNull(sourceText);
    }

    @GwtSerializationConstructor
    protected AbstractCreateEntitiesAction() {
    }

    public String getSourceText() {
        return sourceText;
    }
}
