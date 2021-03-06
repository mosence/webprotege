package edu.stanford.bmir.protege.web.shared.hierarchy;

import com.google.common.base.Objects;
import edu.stanford.bmir.protege.web.client.dispatch.AbstractHasProjectAction;
import edu.stanford.bmir.protege.web.shared.annotations.GwtSerializationConstructor;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 28 Nov 2017
 */
public class GetHierarchyChildrenAction extends AbstractHasProjectAction<GetHierarchyChildrenResult> {

    private OWLEntity entity;

    private HierarchyId hierarchyId;

    public GetHierarchyChildrenAction(@Nonnull ProjectId projectId,
                                      @Nonnull OWLEntity entity,
                                      @Nonnull HierarchyId hierarchyId) {
        super(projectId);
        this.entity = checkNotNull(entity);
        this.hierarchyId = checkNotNull(hierarchyId);
    }

    @GwtSerializationConstructor
    private GetHierarchyChildrenAction() {
    }

    public OWLEntity getEntity() {
        return entity;
    }

    public HierarchyId getHierarchyId() {
        return hierarchyId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(entity, hierarchyId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetHierarchyChildrenAction)) {
            return false;
        }
        GetHierarchyChildrenAction other = (GetHierarchyChildrenAction) obj;
        return this.entity.equals(other.entity)
                && this.hierarchyId.equals(other.hierarchyId)
                && this.getProjectId().equals(other.getProjectId());
    }


    @Override
    public String toString() {
        return toStringHelper("GetHierarchyChildrenAction")
                .addValue(getProjectId())
                .addValue(hierarchyId)
                .addValue(entity)
                .toString();
    }
}
